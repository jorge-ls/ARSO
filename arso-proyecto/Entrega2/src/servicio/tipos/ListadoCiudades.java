package servicio.tipos;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ejercicio3.CiudadResultado;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ListadoCiudades {

	@XmlElement(required=true)
	private List<CiudadResultado> ciudadesResultado = new LinkedList<CiudadResultado>();

	public List<CiudadResultado> getCiudadesResultado() {
		return ciudadesResultado;
	}

	public void setCiudadesResultado(List<CiudadResultado> ciudadesResultado) {
		this.ciudadesResultado = ciudadesResultado;
	}
	
}
