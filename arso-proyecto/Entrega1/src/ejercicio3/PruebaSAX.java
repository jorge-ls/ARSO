package ejercicio3;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class PruebaSAX {

	public static void main(String[] args) throws ParserConfigurationException, SAXException {

		
		// 1. Obtener una factoría
		SAXParserFactory factoria = SAXParserFactory.newInstance();
	
		// 2. Pedir a la factor�a la construcción del analizador
		SAXParser analizador = factoria.newSAXParser(); 
		
		// 3. Analizar el documento

		try {
			Manejador manejador = new Manejador();
			analizador.parse("http://api.geonames.org/search?q=cartagena&type=xml&username=arso&maxRows=10", manejador);
			
			List<CiudadResultado> listaCiudades = manejador.getResultado();
			for (CiudadResultado ciudad : listaCiudades) {
				System.out.println("Nombre: " + ciudad.getCiudad() + ", país: " + ciudad.getPais() + ", id: " + 
						ciudad.getId() + ", longitud: " + ciudad.getLongitud() + ", latitud: " + ciudad.getLatitud() + 
						", URI: " + ciudad.getURI());
			}
		} 
		catch (IOException e) {
			System.out.println("El documento no ha podido ser leído");
		}
		catch (SAXException e) {
			System.out.println("Error de pocesamiento: " + e.getMessage());
		}

	}
}
