package ejercicio4;

public class Ejercicio4 {
	public static void main(String[] args) throws Exception {
		String codigo = "2520058";
		AnalizadorDOM analizador = new AnalizadorDOM();
		CiudadPOJO ciudad = analizador.analizador(codigo);
		
		ProcesadorStAX procesador = new ProcesadorStAX();
		procesador.procesar(ciudad);
	}
}
