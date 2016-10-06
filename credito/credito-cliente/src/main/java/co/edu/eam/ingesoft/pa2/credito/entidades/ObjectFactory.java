
package co.edu.eam.ingesoft.pa2.credito.entidades;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.edu.eam.ingesoft.pa2.credito.entidades package. 
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

    private final static QName _ConsultarCiudadanoResponse_QNAME = new QName("http://co.gov.centralriesgo.consulta", "consultarCiudadanoResponse");
    private final static QName _ConsultasCiudadanoEntidad_QNAME = new QName("http://co.gov.centralriesgo.consulta", "consultasCiudadanoEntidad");
    private final static QName _ConsultarCiudadano_QNAME = new QName("http://co.gov.centralriesgo.consulta", "consultarCiudadano");
    private final static QName _RespuestaConsultasDataCreditoDTO_QNAME = new QName("http://co.gov.centralriesgo.consulta", "respuestaConsultasDataCreditoDTO");
    private final static QName _ConsultasCiudadanoEntidadResponse_QNAME = new QName("http://co.gov.centralriesgo.consulta", "consultasCiudadanoEntidadResponse");
    private final static QName _RespuestaScoreDataCreditoDTO_QNAME = new QName("http://co.gov.centralriesgo.consulta", "respuestaScoreDataCreditoDTO");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.eam.ingesoft.pa2.credito.entidades
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultasCiudadanoEntidadResponse }
     * 
     */
    public ConsultasCiudadanoEntidadResponse createConsultasCiudadanoEntidadResponse() {
        return new ConsultasCiudadanoEntidadResponse();
    }

    /**
     * Create an instance of {@link RespuestaScoreDataCreditoDTO }
     * 
     */
    public RespuestaScoreDataCreditoDTO createRespuestaScoreDataCreditoDTO() {
        return new RespuestaScoreDataCreditoDTO();
    }

    /**
     * Create an instance of {@link RespuestaConsultasDataCreditoDTO }
     * 
     */
    public RespuestaConsultasDataCreditoDTO createRespuestaConsultasDataCreditoDTO() {
        return new RespuestaConsultasDataCreditoDTO();
    }

    /**
     * Create an instance of {@link ConsultasCiudadanoEntidad }
     * 
     */
    public ConsultasCiudadanoEntidad createConsultasCiudadanoEntidad() {
        return new ConsultasCiudadanoEntidad();
    }

    /**
     * Create an instance of {@link ConsultarCiudadano }
     * 
     */
    public ConsultarCiudadano createConsultarCiudadano() {
        return new ConsultarCiudadano();
    }

    /**
     * Create an instance of {@link ConsultarCiudadanoResponse }
     * 
     */
    public ConsultarCiudadanoResponse createConsultarCiudadanoResponse() {
        return new ConsultarCiudadanoResponse();
    }

    /**
     * Create an instance of {@link Consulta }
     * 
     */
    public Consulta createConsulta() {
        return new Consulta();
    }

    /**
     * Create an instance of {@link Ciudadano }
     * 
     */
    public Ciudadano createCiudadano() {
        return new Ciudadano();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCiudadanoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.gov.centralriesgo.consulta", name = "consultarCiudadanoResponse")
    public JAXBElement<ConsultarCiudadanoResponse> createConsultarCiudadanoResponse(ConsultarCiudadanoResponse value) {
        return new JAXBElement<ConsultarCiudadanoResponse>(_ConsultarCiudadanoResponse_QNAME, ConsultarCiudadanoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultasCiudadanoEntidad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.gov.centralriesgo.consulta", name = "consultasCiudadanoEntidad")
    public JAXBElement<ConsultasCiudadanoEntidad> createConsultasCiudadanoEntidad(ConsultasCiudadanoEntidad value) {
        return new JAXBElement<ConsultasCiudadanoEntidad>(_ConsultasCiudadanoEntidad_QNAME, ConsultasCiudadanoEntidad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCiudadano }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.gov.centralriesgo.consulta", name = "consultarCiudadano")
    public JAXBElement<ConsultarCiudadano> createConsultarCiudadano(ConsultarCiudadano value) {
        return new JAXBElement<ConsultarCiudadano>(_ConsultarCiudadano_QNAME, ConsultarCiudadano.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaConsultasDataCreditoDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.gov.centralriesgo.consulta", name = "respuestaConsultasDataCreditoDTO")
    public JAXBElement<RespuestaConsultasDataCreditoDTO> createRespuestaConsultasDataCreditoDTO(RespuestaConsultasDataCreditoDTO value) {
        return new JAXBElement<RespuestaConsultasDataCreditoDTO>(_RespuestaConsultasDataCreditoDTO_QNAME, RespuestaConsultasDataCreditoDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultasCiudadanoEntidadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.gov.centralriesgo.consulta", name = "consultasCiudadanoEntidadResponse")
    public JAXBElement<ConsultasCiudadanoEntidadResponse> createConsultasCiudadanoEntidadResponse(ConsultasCiudadanoEntidadResponse value) {
        return new JAXBElement<ConsultasCiudadanoEntidadResponse>(_ConsultasCiudadanoEntidadResponse_QNAME, ConsultasCiudadanoEntidadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaScoreDataCreditoDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.gov.centralriesgo.consulta", name = "respuestaScoreDataCreditoDTO")
    public JAXBElement<RespuestaScoreDataCreditoDTO> createRespuestaScoreDataCreditoDTO(RespuestaScoreDataCreditoDTO value) {
        return new JAXBElement<RespuestaScoreDataCreditoDTO>(_RespuestaScoreDataCreditoDTO_QNAME, RespuestaScoreDataCreditoDTO.class, null, value);
    }

}
