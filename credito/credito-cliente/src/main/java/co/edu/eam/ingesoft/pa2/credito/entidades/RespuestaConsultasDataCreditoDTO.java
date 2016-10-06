
package co.edu.eam.ingesoft.pa2.credito.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para respuestaConsultasDataCreditoDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="respuestaConsultasDataCreditoDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoResp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consulta" type="{http://co.gov.centralriesgo.consulta}consulta" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="respuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaConsultasDataCreditoDTO", propOrder = {
    "codigoResp",
    "consulta",
    "respuesta"
})
public class RespuestaConsultasDataCreditoDTO {

    protected String codigoResp;
    @XmlElement(nillable = true)
    protected List<Consulta> consulta;
    protected String respuesta;

    /**
     * Obtiene el valor de la propiedad codigoResp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoResp() {
        return codigoResp;
    }

    /**
     * Define el valor de la propiedad codigoResp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoResp(String value) {
        this.codigoResp = value;
    }

    /**
     * Gets the value of the consulta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consulta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsulta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Consulta }
     * 
     * 
     */
    public List<Consulta> getConsulta() {
        if (consulta == null) {
            consulta = new ArrayList<Consulta>();
        }
        return this.consulta;
    }

    /**
     * Obtiene el valor de la propiedad respuesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * Define el valor de la propiedad respuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespuesta(String value) {
        this.respuesta = value;
    }

}
