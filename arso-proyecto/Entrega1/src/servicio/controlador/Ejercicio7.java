package servicio.controlador;

import ejercicio3.CiudadResultado;
import servicio.tipos.ListadoCiudades;

public class Ejercicio7 {
	public static void main(String[] args) throws Exception {
		ServicioGeoNames servicio = new ServicioGeoNames();

		ListadoCiudades listadoCiudades = servicio.getResultdoBusquedaXML("cartagena");
		for (CiudadResultado ciudad : listadoCiudades.getCiudadesResultado()) {
			System.out.println("Ciudad = " + ciudad.getCiudad() + "; País = " + ciudad.getPais());
		}
		
		String id = servicio.crearDocumentoFavoritos();
		System.out.println(id);
		
		String idGeoNames = "2520058";
		servicio.addCiudadFavorita(id, idGeoNames);
		servicio.addCiudadFavorita(id, idGeoNames);
		idGeoNames = "3687238";
		servicio.addCiudadFavorita(id, idGeoNames);
		
		idGeoNames = "2520058";
		System.out.println(servicio.removeCiudadFavorita(id, idGeoNames));
		
		CiudadesFavoritas ciudadesFavoritas = servicio.getFavoritos(id);
		for (String ciudad : ciudadesFavoritas.getCiudad()) {
			System.out.println("Ciudad favorita = " + ciudad);
		}
		
		servicio.removeDocumentoFavoritos(id);
	}
}
