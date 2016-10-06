
package co.edu.eam.ingesoft.pa2.credito.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultarCiudadanoResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultarCiudadanoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="respuestaConsultarCiudadano" type="{http://co.gov.centralriesgo.consulta}respuestaScoreDataCreditoDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarCiudadanoResponse", propOrder = {
    "respuestaConsultarCiudadano"
})
public class ConsultarCiudadanoResponse {

    protected RespuestaScoreDataCreditoDTO respuestaConsultarCiudadano;

    /**
     * Obtiene el valor de la propiedad respuestaConsultarCiudadano.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaScoreDataCreditoDTO }
     *     
     */
    public RespuestaScoreDataCreditoDTO getRespuestaConsultarCiudadano() {
        return respuestaConsultarCiudadano;
    }

    /**
     * Define el valor de la propiedad respuestaConsultarCiudadano.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaScoreDataCreditoDTO }
     *     
     */
    public void setRespuestaConsultarCiudadano(RespuestaScoreDataCreditoDTO value) {
        this.respuestaConsultarCiudadano = value;
    }

}
