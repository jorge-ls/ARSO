package ejercicio4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AnalizadorDOM {
	public CiudadPOJO analizador(String codigo) throws Exception {		
		// 1. Obtener una factoría
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		factoria.setNamespaceAware(true);
		// 2. Pedir a la factoría la construcción del analizador
		DocumentBuilder analizador = factoria.newDocumentBuilder();
		// 3. Analizar el documento
		Document documentoURLRecurso = analizador.parse("http://sws.geonames.org/" + codigo + "/about.rdf");
		
		NodeList listaNodos = documentoURLRecurso.getElementsByTagNameNS("http://www.geonames.org/ontology#", "Feature");
		Element elementoRaiz = (Element) listaNodos.item(0);
		NodeList listaNombres = elementoRaiz.getElementsByTagNameNS("http://www.geonames.org/ontology#", "name");
		Element elementoNombre = (Element) listaNombres.item(0);
		NodeList listaCodigoPaises = elementoRaiz.getElementsByTagNameNS("http://www.geonames.org/ontology#", "countryCode");
		Element elementoCodigoPais = (Element) listaCodigoPaises.item(0);
		NodeList listaPoblacion = elementoRaiz.getElementsByTagNameNS("http://www.geonames.org/ontology#", "population");
		Element elementoPoblacion = (Element) listaPoblacion.item(0);
		NodeList listaLatitudes = elementoRaiz.getElementsByTagNameNS("http://www.w3.org/2003/01/geo/wgs84_pos#", "lat");
		Element elementoLatitud = (Element) listaLatitudes.item(0);
		NodeList listaLongitudes = elementoRaiz.getElementsByTagNameNS("http://www.w3.org/2003/01/geo/wgs84_pos#", "long");
		Element elementoLongitud = (Element) listaLongitudes.item(0);
		NodeList listaDBpedia = elementoRaiz.getElementsByTagNameNS("http://www.w3.org/2000/01/rdf-schema#", "seeAlso");
		Element elementoDBpedia = null;
		if (listaDBpedia.getLength() > 0)
			elementoDBpedia = (Element) listaDBpedia.item(0);
		String urlDBpedia = null;
		if (elementoDBpedia != null)
			urlDBpedia = elementoDBpedia.getAttributeNS("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "resource");
		NodeList listaWikipedia = elementoRaiz.getElementsByTagNameNS("http://www.geonames.org/ontology#", "wikipediaArticle");
		Element elementoWikipedia = null;
		if (listaWikipedia.getLength() > 0)
			elementoWikipedia = (Element) listaWikipedia.item(0);
		String urlWikipedia = null;
		if (elementoWikipedia != null)
			urlWikipedia = elementoWikipedia.getAttributeNS("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "resource");
		NodeList listaDatosDocumento = documentoURLRecurso.getElementsByTagNameNS("http://xmlns.com/foaf/0.1/", "Document");
		Element elementoDatosDocumento = (Element) listaDatosDocumento.item(0);
		NodeList listaFechaActualizacion = elementoDatosDocumento.getElementsByTagNameNS("http://purl.org/dc/terms/", "modified");
		Element elementoFechaActualiacion = (Element) listaFechaActualizacion.item(0);
		
		String urlPais = "http://api.geonames.org/countryInfo?country=" + elementoCodigoPais.getTextContent() + "&username=arso";
		Document documentoPais = analizador.parse(urlPais);
		NodeList listaPaises = documentoPais.getElementsByTagName("countryName");
		Element elementoPais = (Element) listaPaises.item(0);
		
		String urlWeather = "http://api.geonames.org/findNearByWeatherXML?lng=" + elementoLongitud.getTextContent() + 
				"&lat=" + elementoLatitud.getTextContent() + "&username=arso";
		Document documentoWeather = analizador.parse(urlWeather);
		NodeList listaFechaYHora = documentoWeather.getElementsByTagName("observationTime");
		Element elementoFechaYHora = (Element) listaFechaYHora.item(0);
		NodeList listaNombreEstacion = documentoWeather.getElementsByTagName("stationName");
		Element elementoNombreEstacion = (Element) listaNombreEstacion.item(0);
		NodeList listaTemperatura = documentoWeather.getElementsByTagName("temperature");
		Element elementoTemperatura = (Element) listaTemperatura.item(0);
		NodeList listaNubes = documentoWeather.getElementsByTagName("clouds");
		Element elementoNubes = (Element) listaNubes.item(0);
		
		NodeList listaURLSitios = elementoRaiz.getElementsByTagNameNS("http://www.geonames.org/ontology#", "nearbyFeatures");
		Element elementoSitios = (Element) listaURLSitios.item(0);
		String URLSitios = elementoSitios.getAttributeNS("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "resource");
		Document documentoNearBy = analizador.parse(URLSitios);
		NodeList listaSitios = documentoNearBy.getElementsByTagNameNS("http://www.geonames.org/ontology#", "Feature");
		LinkedList<Sitio> sitios = new LinkedList<Sitio>();
		for (int i = 0; i < listaSitios.getLength(); i++) {
			Element elementoSitio = (Element) listaSitios.item(i);
			String URLSitio = elementoSitio.getAttributeNS("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "about");
			String codigoString = URLSitio.substring(24, URLSitio.length() - 1);
			NodeList listaNombresSitios = elementoSitio.getElementsByTagNameNS("http://www.geonames.org/ontology#", "name");
			Element elementoNombreSitio = (Element) listaNombresSitios.item(0);
			Sitio sitio = new Sitio();
			sitio.setCodigo(Integer.parseInt(codigoString));
			sitio.setNombreSitio(elementoNombreSitio.getTextContent());
			sitios.add(sitio);
		}
		
		CiudadPOJO ciudad = new CiudadPOJO();
		ciudad.setCodigo(Integer.parseInt(codigo));
		ciudad.setNombre(elementoNombre.getTextContent());
		ciudad.setPais(elementoPais.getTextContent());
		ciudad.setPoblacion(Integer.parseInt(elementoPoblacion.getTextContent()));
		Ubicacion ubi = new Ubicacion();
		ubi.setLatitud(Double.parseDouble(elementoLatitud.getTextContent()));
		ubi.setLongitud(Double.parseDouble(elementoLongitud.getTextContent()));
		ciudad.setUbicacion(ubi);
		ciudad.setDbpedia(urlDBpedia);
		ciudad.setWikipedia(urlWikipedia);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ciudad.setFechaActualizacion(format.parse(elementoFechaActualiacion.getTextContent()));
		InformacionMeteorologica info = new InformacionMeteorologica();
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fechaYHora = elementoFechaYHora.getTextContent();
		info.setFecha(fechaYHora.substring(0, 10));
		info.setHora(fechaYHora.substring(11, fechaYHora.length()));
		info.setNombreEstacion(elementoNombreEstacion.getTextContent());
		info.setTemperatura(Double.parseDouble(elementoTemperatura.getTextContent()));
		info.setNubes(elementoNubes.getTextContent());
		ciudad.setInformacionMeteorologica(info);
		ciudad.setSitiosDeInteres(sitios);
		return ciudad;
	}
}
