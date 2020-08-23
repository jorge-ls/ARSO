package ejercicio5;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformacionEjercicio5 {

	public static void main(String[] args) throws Exception {
		
		final String documentoEntrada = "http://api.geonames.org/search?q=cartagena&maxRows=10&username=arso&type=xml";
		final String documentoSalida = "xml-bd/salida-ejercicio1-5.xml";
		final String transformacion = "xml/ejercicio1-5.xsl";
		
		
		TransformerFactory factoria = TransformerFactory.newInstance();
		
		Transformer transformador =	factoria.newTransformer(new StreamSource(transformacion));
		Source origen = new StreamSource(documentoEntrada);
		Result destino = new StreamResult(documentoSalida);
		transformador.transform(origen, destino); 
		
		System.out.println("fin.");
	}
}
