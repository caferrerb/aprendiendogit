
package co.edu.eam.ingesoft.pa2.credito.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultasCiudadanoEntidadResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultasCiudadanoEntidadResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="respuestaconsultas" type="{http://co.gov.centralriesgo.consulta}respuestaConsultasDataCreditoDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultasCiudadanoEntidadResponse", propOrder = {
    "respuestaconsultas"
})
public class ConsultasCiudadanoEntidadResponse {

    protected RespuestaConsultasDataCreditoDTO respuestaconsultas;

    /**
     * Obtiene el valor de la propiedad respuestaconsultas.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaConsultasDataCreditoDTO }
     *     
     */
    public RespuestaConsultasDataCreditoDTO getRespuestaconsultas() {
        return respuestaconsultas;
    }

    /**
     * Define el valor de la propiedad respuestaconsultas.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaConsultasDataCreditoDTO }
     *     
     */
    public void setRespuestaconsultas(RespuestaConsultasDataCreditoDTO value) {
        this.respuestaconsultas = value;
    }

}
