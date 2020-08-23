package ejercicio3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CiudadResultado {

	@XmlElement(required=true)
	private String ciudad;
	@XmlElement(required=true)
	private String pais;
	@XmlAttribute(required=true)
	private int idGeoname;
	@XmlElement(required=true)
	private double longitud;
	@XmlElement(required=true)
	private double latitud;
	@XmlElement(required=true)
	private String URI;
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public int getId() {
		return idGeoname;
	}
	
	public void setId(int idGeoname) {
		this.idGeoname = idGeoname;
	}
	
	public double getLongitud() {
		return longitud;
	}
	
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public double getLatitud() {
		return latitud;
	}
	
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}


}
