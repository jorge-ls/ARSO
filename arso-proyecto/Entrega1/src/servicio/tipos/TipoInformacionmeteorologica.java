//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.03.14 a las 05:08:02 PM CET 
//


package servicio.tipos;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para tipo_informacionmeteorologica complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipo_informacionmeteorologica">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechayhora" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="nombreestacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temperatura" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="nubes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipo_informacionmeteorologica", propOrder = {
    "fechayhora",
    "nombreestacion",
    "temperatura",
    "nubes"
})
public class TipoInformacionmeteorologica {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechayhora;
    @XmlElement(required = true)
    protected String nombreestacion;
    @XmlElement(required = true)
    protected BigDecimal temperatura;
    @XmlElement(required = true)
    protected String nubes;

    /**
     * Obtiene el valor de la propiedad fechayhora.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechayhora() {
        return fechayhora;
    }

    /**
     * Define el valor de la propiedad fechayhora.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechayhora(XMLGregorianCalendar value) {
        this.fechayhora = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreestacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreestacion() {
        return nombreestacion;
    }

    /**
     * Define el valor de la propiedad nombreestacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreestacion(String value) {
        this.nombreestacion = value;
    }

    /**
     * Obtiene el valor de la propiedad temperatura.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTemperatura() {
        return temperatura;
    }

    /**
     * Define el valor de la propiedad temperatura.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTemperatura(BigDecimal value) {
        this.temperatura = value;
    }

    /**
     * Obtiene el valor de la propiedad nubes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNubes() {
        return nubes;
    }

    /**
     * Define el valor de la propiedad nubes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNubes(String value) {
        this.nubes = value;
    }

}
