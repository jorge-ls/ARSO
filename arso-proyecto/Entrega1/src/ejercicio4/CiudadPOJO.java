package ejercicio4;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CiudadPOJO {

	private int codigo;
	private String nombre;
	private String pais;
	private int poblacion;
	private Ubicacion ubicacion;
	private String dbpedia;
	private String wikipedia;
	private Date fechaActualizacion;
	private InformacionMeteorologica informacionMeteorologica;
	private List<Sitio> sitiosDeInteres;
	
	public CiudadPOJO () {
		sitiosDeInteres = new LinkedList<Sitio>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDbpedia() {
		return dbpedia;
	}

	public void setDbpedia(String dbpedia) {
		this.dbpedia = dbpedia;
	}

	public String getWikipedia() {
		return wikipedia;
	}

	public void setWikipedia(String wikipedia) {
		this.wikipedia = wikipedia;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public InformacionMeteorologica getInformacionMeteorologica() {
		return informacionMeteorologica;
	}

	public void setInformacionMeteorologica(InformacionMeteorologica informacionMeteorologica) {
		this.informacionMeteorologica = informacionMeteorologica;
	}

	public List<Sitio> getSitiosDeInteres() {
		return sitiosDeInteres;
	}

	public void setSitiosDeInteres(List<Sitio> sitiosDeInteres) {
		this.sitiosDeInteres = sitiosDeInteres;
	}
	
}
