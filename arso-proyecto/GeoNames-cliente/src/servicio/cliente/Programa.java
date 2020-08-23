package servicio.cliente;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import ejercicio3.CiudadResultado;
import servicio.controlador.CiudadesFavoritas;
import servicio.tipos.Ciudad;
import servicio.tipos.ListadoCiudades;

public class Programa {
	
	private static final String URL_SERVICIO = "http://localhost:8080/CampilloCanovas-David-entrega2/rest/";
	
	public static void main(String[] args) {
		
		//Se invoca la operacion "getResultadosBusquedaXML"
		Client cliente = Client.create();
		String parametro = "busqueda";
		String valor = "cartagena";
		String path = "ciudades?" + parametro + "=" + valor;
		WebResource recurso = cliente.resource(URL_SERVICIO + path);
		recurso.queryParam(parametro, valor);
		Builder builder = recurso.accept(MediaType.APPLICATION_XML);
		ClientResponse respuesta = builder.method("GET", ClientResponse.class);
		ListadoCiudades listaCiudades = respuesta.getEntity(ListadoCiudades.class);
		List<CiudadResultado> ciudades = listaCiudades.getCiudadesResultado();
		System.out.println("Codigo de retorno: "+respuesta.getStatus());
		for (CiudadResultado ciudadResultado : ciudades) {
			System.out.println("Ciudad: "+ciudadResultado.getCiudad());
		}
		System.out.println();
		
		//Se invoca a la operacion "getCiudad"
		String idCiudad = "2520058";
		String ciudadPath = "ciudades/" + idCiudad;
		recurso = cliente.resource(URL_SERVICIO + ciudadPath);
		builder = recurso.accept(MediaType.APPLICATION_XML);
		respuesta = builder.method("GET", ClientResponse.class);
		Ciudad ciudad = respuesta.getEntity(Ciudad.class);
		System.out.println("Codigo de retorno: " + respuesta.getStatus());
		System.out.println("Ciudad: " + ciudad.getNombre());
		System.out.println("Pais: " + ciudad.getPais());
		System.out.println("Poblacion: " + ciudad.getPoblacion());
		System.out.println();
		
		//Se crea un documento de favoritos
		String documentoPath = "ciudades/favoritas";
		recurso = cliente.resource(URL_SERVICIO + documentoPath);
		respuesta = recurso.method("POST", ClientResponse.class);
		System.out.println("Codigo de retorno: " + respuesta.getStatus());
		String documentoURL = respuesta.getLocation().toString();
		System.out.println("Url del documento: " + documentoURL);
		System.out.println();
		
		//Se añade una ciudad al documento de ciudades favoritas
		String idFavoritas = documentoURL.substring(documentoURL.length() - 36);
		String nuevaFavorita = "ciudades/favoritas/" + idFavoritas + "/" + idCiudad;
		recurso = cliente.resource(URL_SERVICIO + nuevaFavorita);
		respuesta = recurso.method("PUT", ClientResponse.class);
		System.out.println("Codigo de retorno: " + respuesta.getStatus());
		System.out.println();

		//Obtener documento de ciudades favoritas
		String favoritas = "ciudades/favoritas/" + idFavoritas;
		recurso = cliente.resource(URL_SERVICIO + favoritas);
		respuesta = builder.method("GET", ClientResponse.class);
		System.out.println("Codigo de retorno: " + respuesta.getStatus());
		CiudadesFavoritas ciudadesFavoritas = respuesta.getEntity(CiudadesFavoritas.class);
		for (String favorita : ciudadesFavoritas.getCiudad()) {
			System.out.println(favorita);
		}
		System.out.println();
		
		//Borrar ciudad favorita
		respuesta = recurso.method("DELETE", ClientResponse.class);
		System.out.println("Codigo de retorno: " + respuesta.getStatus());
		System.out.println();
		
		//Obtener documento de ciudades favoritas
		recurso = cliente.resource(documentoURL);
		respuesta = builder.method("GET", ClientResponse.class);
		System.out.println("Codigo de retorno: " + respuesta.getStatus());
		/*CiudadesFavoritas favoritas = respuesta.getEntity(CiudadesFavoritas.class);
		for (String favorita : favoritas.getCiudad()) {
			System.out.println(favorita);
		}*/
		System.out.println();
		
		
		//Borrar documento de ciudades favoritas
		recurso = cliente.resource(documentoURL);
		respuesta = recurso.method("DELETE", ClientResponse.class);
		System.out.println("Codigo de retorno: " + respuesta.getStatus());
		System.out.println();
				
		//Buscar cartagena en JSON
		path = "ciudades?" + parametro + "=" + valor;
		recurso = cliente.resource(URL_SERVICIO + path);
		recurso.queryParam(parametro, valor);
		builder = recurso.accept(MediaType.APPLICATION_JSON);
		respuesta = builder.method("GET", ClientResponse.class);
		listaCiudades = respuesta.getEntity(ListadoCiudades.class);
		ciudades = listaCiudades.getCiudadesResultado();
		System.out.println("Codigo de retorno: " + respuesta.getStatus());
		for (CiudadResultado ciudadResultado : ciudades) {
			System.out.println("Ciudad: " + ciudadResultado.getCiudad());
		}
		System.out.println();
	}
}
