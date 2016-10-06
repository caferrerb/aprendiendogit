
package co.edu.eam.ingesoft.pa2.credito.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ciudadano complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ciudadano">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroDoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoDoc" type="{http://co.gov.centralriesgo.consulta}tipoDocEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ciudadano", propOrder = {
    "apellido",
    "nombre",
    "numeroDoc",
    "tipoDoc"
})
public class Ciudadano {

    protected String apellido;
    protected String nombre;
    protected String numeroDoc;
    @XmlSchemaType(name = "string")
    protected TipoDocEnum tipoDoc;

    /**
     * Obtiene el valor de la propiedad apellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Define el valor de la propiedad apellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellido(String value) {
        this.apellido = value;
    }

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
     * Obtiene el valor de la propiedad numeroDoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDoc() {
        return numeroDoc;
    }

    /**
     * Define el valor de la propiedad numeroDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDoc(String value) {
        this.numeroDoc = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDoc.
     * 
     * @return
     *     possible object is
     *     {@link TipoDocEnum }
     *     
     */
    public TipoDocEnum getTipoDoc() {
        return tipoDoc;
    }

    /**
     * Define el valor de la propiedad tipoDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoDocEnum }
     *     
     */
    public void setTipoDoc(TipoDocEnum value) {
        this.tipoDoc = value;
    }

}
