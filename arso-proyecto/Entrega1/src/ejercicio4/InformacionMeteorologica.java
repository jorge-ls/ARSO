package ejercicio4;


public class InformacionMeteorologica {

	private String fecha;
	private String hora;
	private String nombreEstacion;
	private double temperatura;
	private String nubes;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getNombreEstacion() {
		return nombreEstacion;
	}

	public void setNombreEstacion(String nombreEstacion) {
		this.nombreEstacion = nombreEstacion;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public String getNubes() {
		return nubes;
	}

	public void setNubes(String nubes) {
		this.nubes = nubes;
	}
	
}
