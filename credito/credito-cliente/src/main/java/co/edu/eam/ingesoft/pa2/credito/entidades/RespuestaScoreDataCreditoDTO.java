
package co.edu.eam.ingesoft.pa2.credito.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para respuestaScoreDataCreditoDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="respuestaScoreDataCreditoDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoResp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consulta" type="{http://co.gov.centralriesgo.consulta}consulta" minOccurs="0"/>
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
@XmlType(name = "respuestaScoreDataCreditoDTO", propOrder = {
    "codigoResp",
    "consulta",
    "respuesta"
})
public class RespuestaScoreDataCreditoDTO {

    protected String codigoResp;
    protected Consulta consulta;
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
     * Obtiene el valor de la propiedad consulta.
     * 
     * @return
     *     possible object is
     *     {@link Consulta }
     *     
     */
    public Consulta getConsulta() {
        return consulta;
    }

    /**
     * Define el valor de la propiedad consulta.
     * 
     * @param value
     *     allowed object is
     *     {@link Consulta }
     *     
     */
    public void setConsulta(Consulta value) {
        this.consulta = value;
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
