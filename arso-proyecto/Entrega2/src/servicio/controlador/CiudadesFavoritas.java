package servicio.controlador;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CiudadesFavoritas {

	@XmlAttribute(required=true)
	public String id;
	@XmlElement(required=true)
	public List<String> ciudad;
	
	public CiudadesFavoritas() {
		ciudad = new LinkedList<String>();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<String> getCiudad() {
		return ciudad;
	}
	
}
