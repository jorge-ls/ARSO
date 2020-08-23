package ejercicio4;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class ProcesadorStAX {
	public void procesar(CiudadPOJO ciudad) throws Exception {
		XMLOutputFactory xof = XMLOutputFactory.newInstance();
		XMLStreamWriter writer = xof.createXMLStreamWriter(new FileOutputStream("xml-bd/" + ciudad.getCodigo() + ".xml"));
		
		writer.writeStartDocument();
		writer.writeStartElement("ciudad");
		writer.writeNamespace("", "http://www.example.org/ejercicio1-2");
		writer.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		writer.writeAttribute("http://www.w3.org/2001/XMLSchema-instance", "schemaLocation", 
				"http://www.example.org/ejercicio1-2 ../xml/ejercicio1-2.xsd");
		writer.writeAttribute("codigo", Integer.toString(ciudad.getCodigo()));
		
		writer.writeStartElement("nombre");
		writer.writeCharacters(ciudad.getNombre());
		writer.writeEndElement();

		writer.writeStartElement("pais");
		writer.writeCharacters(ciudad.getPais());
		writer.writeEndElement();
		
		writer.writeStartElement("poblacion");
		writer.writeCharacters(Integer.toString(ciudad.getPoblacion()));
		writer.writeEndElement();
		
		writer.writeStartElement("ubicacion");
		writer.writeStartElement("latitud");
		writer.writeCharacters(Double.toString(ciudad.getUbicacion().getLatitud()));
		writer.writeEndElement();
		writer.writeStartElement("longitud");
		writer.writeCharacters(Double.toString(ciudad.getUbicacion().getLongitud()));
		writer.writeEndElement();
		writer.writeEndElement();
		
		if (ciudad.getDbpedia() != null) {
			writer.writeStartElement("dbpedia");
			writer.writeCharacters(ciudad.getDbpedia());
			writer.writeEndElement();
		}
		
		if (ciudad.getWikipedia() != null) {
			writer.writeStartElement("wikipedia");
			writer.writeCharacters(ciudad.getWikipedia());
			writer.writeEndElement();
		}
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		writer.writeStartElement("fechaactualizacion");
		writer.writeCharacters(format.format(ciudad.getFechaActualizacion()));
		writer.writeEndElement();
		
		writer.writeStartElement("informacionmeteorologica");
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		writer.writeStartElement("fechayhora");
		String hora = ciudad.getInformacionMeteorologica().getHora();
		if (hora.length() < 8)
			hora = "0" + hora;
		String fechaYHora = ciudad.getInformacionMeteorologica().getFecha() + "T" + hora;
		writer.writeCharacters(fechaYHora);
		writer.writeEndElement();
		writer.writeStartElement("nombreestacion");
		writer.writeCharacters(ciudad.getInformacionMeteorologica().getNombreEstacion());
		writer.writeEndElement();
		writer.writeStartElement("temperatura");
		writer.writeCharacters(Double.toString(ciudad.getInformacionMeteorologica().getTemperatura()));
		writer.writeEndElement();
		writer.writeStartElement("nubes");
		writer.writeCharacters(ciudad.getInformacionMeteorologica().getNubes());
		writer.writeEndElement();
		writer.writeEndElement();
		
		List<Sitio> sitios = ciudad.getSitiosDeInteres();
		
		for (Sitio sitio : sitios) {
			writer.writeStartElement("sitio");
			writer.writeAttribute("codigo", Integer.toString(sitio.getCodigo()));
			writer.writeStartElement("nombre");
			writer.writeCharacters(sitio.getNombreSitio());
			writer.writeEndElement();
			writer.writeEndElement();
		}
		
		writer.writeEndElement();
		writer.writeEndDocument();
		writer.flush();
		writer.close();
	}
}
