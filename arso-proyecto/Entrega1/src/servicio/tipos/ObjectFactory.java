//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.03.14 a las 05:08:02 PM CET 
//


package servicio.tipos;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ciudades package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ciudades
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ciudad }
     * 
     */
    public Ciudad createCiudad() {
        return new Ciudad();
    }

    /**
     * Create an instance of {@link TipoUbicacion }
     * 
     */
    public TipoUbicacion createTipoUbicacion() {
        return new TipoUbicacion();
    }

    /**
     * Create an instance of {@link TipoInformacionmeteorologica }
     * 
     */
    public TipoInformacionmeteorologica createTipoInformacionmeteorologica() {
        return new TipoInformacionmeteorologica();
    }

    /**
     * Create an instance of {@link TipoSitio }
     * 
     */
    public TipoSitio createTipoSitio() {
        return new TipoSitio();
    }
    
    /**
     * Create an instance of {@link TipoLibro }
     * 
     */
    public TipoLibro createTipoLibro() {
        return new TipoLibro();
    }

}
