package servicio.controlador;


import java.util.List;
import servicio.tipos.Ciudad;
import servicio.tipos.TipoLibro;

public class Ejercicio2_1 {
	
	public static void main(String[] args) throws GeonamesException {
		
		ServicioGeoNames servicio = new ServicioGeoNames();
		Ciudad ciudad = servicio.getCiudad("2520058");
		List<TipoLibro> libros = ciudad.getLibro();
		
		System.out.println("Libros encontrados:");
		for (TipoLibro libro : libros) {
			System.out.println("Libro id: "+libro.getId());
			System.out.println("Titulo: "+libro.getTitulo());
			System.out.println("ISBN: "+libro.getIsbn());
			System.out.println("Url imagen: "+libro.getUrlImagen());
			System.out.println("Url googleBooks: "+libro.getUrlWeb());
		}
	}

}
