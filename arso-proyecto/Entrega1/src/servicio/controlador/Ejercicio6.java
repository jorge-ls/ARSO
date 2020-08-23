package servicio.controlador;

import java.util.List;

import ejercicio3.CiudadResultado;
import servicio.tipos.Ciudad;

public class Ejercicio6 {
	public static void main(String[] args) throws Exception {
		ServicioGeoNames servicio = new ServicioGeoNames();
		List<CiudadResultado> listaCiudades = servicio.buscar("cartagena");
		
		for (CiudadResultado ciudad : listaCiudades) {
			System.out.println("Codigo: " + ciudad.getId());
		}
		for(int i = 0; i < 2; i++) {
			Ciudad ciudad = servicio.getCiudad(Integer.toString(listaCiudades.get(i).getId()));
			System.out.println("Codigo: "+ciudad.getCodigo());
			System.out.println("Nombre: "+ciudad.getNombre()+" Pais: "+ciudad.getPais()+
					" Poblacion: "+ciudad.getPoblacion()+" Latitud: "
					+ciudad.getUbicacion().getLatitud()+" Longitud: "+ciudad.getUbicacion().getLatitud()+
					" urlDBPedia: "+ciudad.getDbpedia()+" urlWikipedia: "+ciudad.getWikipedia());
			System.out.println("Fecha actualizacion: "+ciudad.getFechaactualizacion());
			System.out.println("Datos Inf Metorologica:");
			System.out.println("Nombre estacion: "+ciudad.getInformacionmeteorologica().getNombreestacion()+" Nubes: "
					+ciudad.getInformacionmeteorologica().getNubes()+"Temperatura: "+ciudad.getInformacionmeteorologica().getTemperatura());
			System.out.println("FechayHora: "+ciudad.getInformacionmeteorologica().getFechayhora());
		}
	}
}
