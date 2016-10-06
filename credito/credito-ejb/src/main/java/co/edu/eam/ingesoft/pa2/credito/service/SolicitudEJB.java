package co.edu.eam.ingesoft.pa2.credito.service;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.pa2.credito.model.Cliente;
import co.edu.eam.ingesoft.pa2.credito.model.Prestamo;
import co.edu.eam.ingesoft.pa2.credito.model.Solicitud;
import co.edu.eam.ingesoft.pa2.credito.util.DAOGenerico;
import co.edu.eam.ingesoft.pa2.credito.util.ExcepcionNegocio;

@LocalBean
@Stateless
public class SolicitudEJB {

	@PersistenceContext
	private EntityManager em;

	private DAOGenerico dao;

	@PostConstruct
	public void init() {
		dao = new DAOGenerico(em);
	}

	/**
	 * 
	 * Método que registra una solicitud de credito. <br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 *         caferrerb<br>
	 * 
	 * @date 28/09/2016
	 * @version 1.0
	 * @param cedula
	 * @param monto
	 * @param numeroCuotas
	 *
	 */
	public Solicitud solicitarCredito(String cedula, double monto, int numeroCuotas) {

		double salario = consultarSalario(cedula);
		double interes = determinarInteres(cedula);
		Cliente c=dao.encontrarPorId(Cliente.class, cedula);
		if(c==null){
			c=new Cliente("Cualquier nombre", cedula);
			dao.persistir(c);
			dao.flush();
		}
		if (interes > 0) {

			double cuota = monto
					* ((interes * Math.pow(1 + interes, numeroCuotas)) / (Math.pow(1 + interes, numeroCuotas) - 1));
			if (cuota < 0.3 * salario) {

				Solicitud sol = new Solicitud(new Cliente("Cualquier nombre", cedula), monto, numeroCuotas, salario,interes );
				dao.persistir(sol);
				return sol;

			} else {
				throw new ExcepcionNegocio("Prestamo Negado, Supera capacidad de endeudamiento");
			}

		} else {
			throw new ExcepcionNegocio("Prestamo Negado, score bajo");
		}

	}

	/**
	 * 
	 * Método que aprueba una solicitud<br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 *         caferrer@eservicios.indracompany.com<br>
	 * 
	 * @date 28/09/2016
	 * @version 1.0
	 * @param id
	 * @return el prestamo
	 *
	 */
	public Prestamo aprobarSolicitud(long id) {
		
		Solicitud sol=dao.encontrarPorId(Solicitud.class, id);
		if(sol!=null){
			double cuota = sol.getMonto()
					* ((sol.getInteres() * Math.pow(1 + sol.getInteres(), sol.getPlazo())) / (Math.pow(1 + sol.getInteres(), sol.getPlazo()) - 1));
			Prestamo p=new Prestamo(sol.getCliente(), sol.getMonto(), sol.getInteres(), sol.getPlazo(), cuota);
			dao.persistir(p);
			return p;
		}else{
			throw new ExcepcionNegocio("Prestamo Negado, score bajo");
		}
		
	}

	/**
	 * 
	 * Método que lista las solicitudes no aprobadas de prestamos. <br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 * 
	 * @date 28/09/2016
	 * @version 1.0
	 * @return
	 *
	 */
	public List<Solicitud> solicitudesPorAprobar() {
		return dao.ejecutarQuery("select s From Solicitud s WHERE s.aprobado=false", null);
	}

	/**
	 * 
	 * Método que determina el interes que se le puede ofrecer al cliente.<br>
	 * si el score de datacredito esta por debajo de 500 el interes es -1
	 * indicando que no es posible dar el credito, de resto se calcula asi:
	 * entre 500 y 600: 24% anual<br>
	 * entre 600 y 700: 20% anual<br>
	 * entre 700 y 800: 16% anual<br>
	 * entre 800 en adelante: 12% anual<br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 * 
	 * @date 28/09/2016
	 * @version 1.0
	 * @param cedula
	 * @return
	 *
	 */
	private double determinarInteres(String cedula) {
		double score = consultarScore(cedula);
		return (score < 500 ? -1
				: score >= 500 && score < 600 ? 0.24
						: score >= 600 && score < 700 ? 0.20
								: score >= 700 && score < 800 ? 0.16 : score >= 800 ? 0.12 : -1)
				/ 12;
	}

	/**
	 * 
	 * Método que consulta el score de credito del servicio de data credito.
	 * <br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 * 
	 * @date 28/09/2016
	 * @version 1.0
	 * @param cedula
	 * @return
	 *
	 */
	private double consultarScore(String cedula) {
		// TODO: invocar el WS del datacertio y retornar el SCORE.
		// el tipo de doc: <tipodoc>CEDULA</tipodoc> siempre sera CEDULA.
		//http://174.142.65.144:28080/orderprocesor/centralriego?wsdl
		return 800;
	}

	/**
	 * 
	 * Método que consulta el servicio del MINTrabajo del salario de un
	 * empleado. <br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 * 
	 * @date 28/09/2016
	 * @version 1.0
	 * @param cedula
	 * @return
	 *
	 */
	private double consultarSalario(String cedula) {
		// TODO Invocar a :
		return new Random().nextDouble()*1000000+500000;
	}

}
