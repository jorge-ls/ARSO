//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.04.18 a las 12:00:12 PM CEST 
//


package servicio.tipos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pais" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="poblacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ubicacion" type="{http://www.example.org/ejercicio1-2}tipo_ubicacion"/>
 *         &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wikipedia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaactualizacion" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="informacionmeteorologica" type="{http://www.example.org/ejercicio1-2}tipo_informacionmeteorologica" minOccurs="0"/>
 *         &lt;element name="sitio" type="{http://www.example.org/ejercicio1-2}tipo_sitio" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="libro" type="{http://www.example.org/ejercicio1-2}tipo_libro" maxOccurs="3" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="codigo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nombre",
    "pais",
    "poblacion",
    "ubicacion",
    "dbpedia",
    "wikipedia",
    "fechaactualizacion",
    "informacionmeteorologica",
    "sitio",
    "libro"
})
@XmlRootElement(name = "ciudad")
public class Ciudad {

    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String pais;
    protected int poblacion;
    @XmlElement(required = true)
    protected TipoUbicacion ubicacion;
    protected String dbpedia;
    protected String wikipedia;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaactualizacion;
    protected TipoInformacionmeteorologica informacionmeteorologica;
    protected List<TipoSitio> sitio;
    protected List<TipoLibro> libro;
    @XmlAttribute(name = "codigo", required = true)
    protected String codigo;

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad pais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define el valor de la propiedad pais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

    /**
     * Obtiene el valor de la propiedad poblacion.
     * 
     */
    public int getPoblacion() {
        return poblacion;
    }

    /**
     * Define el valor de la propiedad poblacion.
     * 
     */
    public void setPoblacion(int value) {
        this.poblacion = value;
    }

    /**
     * Obtiene el valor de la propiedad ubicacion.
     * 
     * @return
     *     possible object is
     *     {@link TipoUbicacion }
     *     
     */
    public TipoUbicacion getUbicacion() {
        return ubicacion;
    }

    /**
     * Define el valor de la propiedad ubicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoUbicacion }
     *     
     */
    public void setUbicacion(TipoUbicacion value) {
        this.ubicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad dbpedia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbpedia() {
        return dbpedia;
    }

    /**
     * Define el valor de la propiedad dbpedia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbpedia(String value) {
        this.dbpedia = value;
    }

    /**
     * Obtiene el valor de la propiedad wikipedia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWikipedia() {
        return wikipedia;
    }

    /**
     * Define el valor de la propiedad wikipedia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWikipedia(String value) {
        this.wikipedia = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaactualizacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaactualizacion() {
        return fechaactualizacion;
    }

    /**
     * Define el valor de la propiedad fechaactualizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaactualizacion(XMLGregorianCalendar value) {
        this.fechaactualizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad informacionmeteorologica.
     * 
     * @return
     *     possible object is
     *     {@link TipoInformacionmeteorologica }
     *     
     */
    public TipoInformacionmeteorologica getInformacionmeteorologica() {
        return informacionmeteorologica;
    }

    /**
     * Define el valor de la propiedad informacionmeteorologica.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInformacionmeteorologica }
     *     
     */
    public void setInformacionmeteorologica(TipoInformacionmeteorologica value) {
        this.informacionmeteorologica = value;
    }

    /**
     * Gets the value of the sitio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sitio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSitio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoSitio }
     * 
     * 
     */
    public List<TipoSitio> getSitio() {
        if (sitio == null) {
            sitio = new ArrayList<TipoSitio>();
        }
        return this.sitio;
    }

    /**
     * Gets the value of the libro property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the libro property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLibro().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoLibro }
     * 
     * 
     */
    public List<TipoLibro> getLibro() {
        if (libro == null) {
            libro = new ArrayList<TipoLibro>();
        }
        return this.libro;
    }

    /**
     * Obtiene el valor de la propiedad codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

}
