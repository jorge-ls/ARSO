package servicio.controlador;

import java.io.File;
import java.net.URLEncoder;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ejercicio3.CiudadResultado;
import ejercicio3.Manejador;
import ejercicio4.AnalizadorDOM;
import ejercicio4.CiudadPOJO;
import ejercicio4.ProcesadorStAX;
import servicio.tipos.Ciudad;
import servicio.tipos.ListadoCiudades;
import servicio.tipos.TipoLibro;

public class ServicioGeoNames {

	static {            
	      File folder = new File("xml-bd");            
	      if (!folder.exists())
	            folder.mkdir();
	}
	
	public List<CiudadResultado> buscar (String busqueda) throws GeonamesException {
		try {
			URLEncoder.encode(busqueda, "UTF8");
			// 1. Obtener una factoría
			SAXParserFactory factoria = SAXParserFactory.newInstance();

			// 2. Pedir a la factor�a la construcción del analizador
			SAXParser analizador = factoria.newSAXParser(); 

			// 3. Analizar el documento
			Manejador manejador = new Manejador();
			analizador.parse("http://api.geonames.org/search?q=" + busqueda + "&featureClass=P&type=xml&username=arso&maxRows=10", manejador);

			List<CiudadResultado> listaCiudades = manejador.getResultado();
			return listaCiudades;
		} catch (Exception e) {
			throw new GeonamesException("Error al obtener la lista de las ciudades que se corresponden con el término " + busqueda, e);
		}
	}
	
	public Ciudad getCiudad (String idGeoNames) throws GeonamesException {
		try {
			LinkedList<TipoLibro> libros = recuperarDocumento(idGeoNames);
			// 1. Construir el contexto JAXB
			JAXBContext contexto = JAXBContext.newInstance("servicio.tipos");
			// 2. Obtener el árbol de contenido de un documento XML
			Unmarshaller unmarshaller = contexto.createUnmarshaller();
			Ciudad ciudad = (Ciudad) unmarshaller.unmarshal(new File("xml-bd/" + idGeoNames + ".xml"));
			for (TipoLibro libro : libros) {
				ciudad.getLibro().add(libro);
			}
			return ciudad;
		} catch (Exception e) {
			throw new GeonamesException("Error al obtener la ciudad con id: " + idGeoNames, e);
		}
	}
	
	private LinkedList<TipoLibro> recuperarDocumento(String idGeoNames) throws GeonamesException {
		File document = new File("xml-bd/" + idGeoNames + ".xml");
		Date date = new Date();
		long hour = 60 * 60 * 1000;

		if (!document.exists() || document.lastModified() < date.getTime() - hour) {
			AnalizadorDOM analizador = new AnalizadorDOM();
			CiudadPOJO ciudad;
			try {
				ciudad = analizador.analizador(idGeoNames);
				ProcesadorStAX procesador = new ProcesadorStAX();
				procesador.procesar(ciudad);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			AnalizadorDOM analizador = new AnalizadorDOM();
			CiudadPOJO ciudad = analizador.analizador(idGeoNames);
			String documento = "http://books.google.com/books/feeds/volumes?q="+ciudad.getNombre()+"&start-index=1&max-results=100";
			XPathFactory factoria = XPathFactory.newInstance();
			XPath xpath = factoria.newXPath();
			xpath.setNamespaceContext(new EspaciosNombres());
			String subject = ciudad.getNombre() + " (" + ciudad.getPais() + ")";
			XPathExpression consulta = xpath.compile("//a:entry[dc:subject='" + subject + "']");
			NodeList listaLibros = (NodeList) consulta.evaluate(new org.xml.sax.InputSource(documento), XPathConstants.NODESET);
			LinkedList<TipoLibro> libros = new LinkedList<TipoLibro>();
			for (int i=0;i<listaLibros.getLength();i++) {
				TipoLibro libro = new TipoLibro();
				Element elemLibro = (Element) listaLibros.item(i);
				NodeList listaTitulo = elemLibro.getElementsByTagNameNS("http://www.w3.org/2005/Atom", "title");
				Element elemTitulo = (Element) listaTitulo.item(0);
				NodeList listaId = elemLibro.getElementsByTagNameNS("http://www.w3.org/2005/Atom", "id");
				Element elemId = (Element) listaId.item(0);
				NodeList listaIsbn = elemLibro.getElementsByTagNameNS("http://purl.org/dc/terms","identifier");
				Element elemIsbn = (Element) listaIsbn.item(0);
				NodeList listaUrl = elemLibro.getElementsByTagNameNS("http://www.w3.org/2005/Atom", "link");
				Element elemUrlImg = (Element) listaUrl.item(0);
				Element elemUrl = (Element) listaUrl.item(1);

				libro.setId(elemId.getTextContent());
				libro.setTitulo(elemTitulo.getTextContent());
				libro.setIsbn(elemIsbn.getTextContent());
				libro.setUrlImagen(elemUrlImg.getAttribute("href"));
				libro.setUrlWeb(elemUrl.getAttribute("href"));
				libros.add(libro);
			}
			return libros;		
		} catch (Exception e) {
			throw new GeonamesException("Error al recuperar el documento de la ciudad con id: " + idGeoNames, e);
		}
		//return null;
	}
	
	public ListadoCiudades getResultdoBusquedaXML(String busqueda) throws GeonamesException {						
		List<CiudadResultado> ciudades = buscar(busqueda);
		ListadoCiudades listaCiudades = new ListadoCiudades();
		listaCiudades.setCiudadesResultado(ciudades);
		return listaCiudades;
	}
	
	public String crearDocumentoFavoritos() throws GeonamesException {
		String id = UUID.randomUUID().toString();
		CiudadesFavoritas ciudadesFavoritas = new CiudadesFavoritas();
		ciudadesFavoritas.setId(id);
		try {
			JAXBContext contexto = JAXBContext.newInstance(CiudadesFavoritas.class);
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(ciudadesFavoritas, new File("xml-bd/favoritos-" + id + ".xml"));
			return id;
		} catch (Exception e) {
			throw new GeonamesException("Error al crear el documento de favoritos", e);
		}
	}
	
	public void addCiudadFavorita(String idFavoritos, String idGeoNames) throws GeonamesException {
		try {
			JAXBContext contexto = JAXBContext.newInstance(CiudadesFavoritas.class);
			Unmarshaller unmarshaller = contexto.createUnmarshaller();
			CiudadesFavoritas ciudadesFavoritas = 
					(CiudadesFavoritas) unmarshaller.unmarshal(new File("xml-bd/favoritos-" + idFavoritos + ".xml"));
			if (!ciudadesFavoritas.getCiudad().contains(idGeoNames)) {
				ciudadesFavoritas.getCiudad().add(idGeoNames);
				Marshaller marshaller = contexto.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				marshaller.marshal(ciudadesFavoritas, new File("xml-bd/favoritos-" + idFavoritos + ".xml"));
			}
		} catch (Exception e) {
			throw new GeonamesException("Error al añadir la ciudad con id " + idGeoNames + " al documento con id " + idFavoritos, e);
		}
	}
	
	public boolean removeCiudadFavorita(String idFavoritos, String idGeoNames) throws GeonamesException {
		try {
			JAXBContext contexto = JAXBContext.newInstance(CiudadesFavoritas.class);
			Unmarshaller unmarshaller = contexto.createUnmarshaller();
			CiudadesFavoritas ciudadesFavoritas = 
					(CiudadesFavoritas) unmarshaller.unmarshal(new File("xml-bd/favoritos-" + idFavoritos + ".xml"));
			if (!ciudadesFavoritas.getCiudad().contains(idGeoNames)) {
				return false;
			} else {
				ciudadesFavoritas.getCiudad().remove(idGeoNames);
				Marshaller marshaller = contexto.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				marshaller.marshal(ciudadesFavoritas, new File("xml-bd/favoritos-" + idFavoritos + ".xml"));
				return true;
			}
		} catch (Exception e) {
			throw new GeonamesException("Error al eliminar la ciudad con id " + idGeoNames + " al documento con id " + idFavoritos, e);
		}
	}
	
	public CiudadesFavoritas getFavoritos(String idFavoritos) throws GeonamesException {
		try {
			JAXBContext contexto = JAXBContext.newInstance(CiudadesFavoritas.class);
			Unmarshaller unmarshaller = contexto.createUnmarshaller();
			CiudadesFavoritas ciudadesFavoritas = 
					(CiudadesFavoritas) unmarshaller.unmarshal(new File("xml-bd/favoritos-" + idFavoritos + ".xml"));
			return ciudadesFavoritas;
		} catch (Exception e) {
			throw new GeonamesException("Error al obtener las ciudades favoritas del documento con id " + idFavoritos, e);
		}
	}
	
	public void removeDocumentoFavoritos(String idFavoritos) {
		File file = new File("xml-bd/favoritos-" + idFavoritos + ".xml");
		file.delete();
	}
	
}
