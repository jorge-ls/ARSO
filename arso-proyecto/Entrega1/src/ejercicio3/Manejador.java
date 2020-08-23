package ejercicio3;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Manejador extends DefaultHandler{
	
	private LinkedList<String> pila;
	private CiudadResultado ciudad;
	private List<CiudadResultado> resultado;
	
	public List<CiudadResultado> getResultado () {
		return resultado;
	}

	@Override
	public void startDocument() throws SAXException {
		pila = new LinkedList<String>();
		resultado = new LinkedList<CiudadResultado>();
	}
	
	@Override
	public void startElement(String uri, String localName, 
			String qName, Attributes attributes) throws SAXException {
		pila.push(qName);
		if (qName.equals("geoname")) {
			ciudad = new CiudadResultado();
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String texto = new String(ch, start, length);
		String element = pila.peek();
		if (!texto.equals("\n"))
			switch (element) {
			case "name":
				ciudad.setCiudad(texto);
				break;
			case "countryName":
				ciudad.setPais(texto);
				break;
			case "geonameId":
				int id = Integer.parseInt(texto);
				ciudad.setId(id);
				break;
			case "lng":
				double lon = Double.parseDouble(texto);
				ciudad.setLongitud(lon);
				break;
			case "lat":
				double lat = Double.parseDouble(texto);
				ciudad.setLatitud(lat);
				break;
			default:
				break;
			}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		pila.pop();
		if (qName.equals("geoname")) {
			ciudad.setURI("http://sws.geonames.org/" + ciudad.getId() + "/about.rdf");
			resultado.add(ciudad);
		}
	}
	
}
