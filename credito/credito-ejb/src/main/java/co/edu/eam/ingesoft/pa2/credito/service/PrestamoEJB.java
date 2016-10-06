package co.edu.eam.ingesoft.pa2.credito.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.pa2.credito.model.Pago;
import co.edu.eam.ingesoft.pa2.credito.model.Prestamo;
import co.edu.eam.ingesoft.pa2.credito.util.DAOGenerico;
import co.edu.eam.ingesoft.pa2.credito.util.ExcepcionNegocio;

@LocalBean
@Stateless
public class PrestamoEJB {

	@PersistenceContext
	private EntityManager em;

	private DAOGenerico dao;

	@PostConstruct
	public void init() {
		dao = new DAOGenerico(em);
	}

	/**
	 * 
	 * Método para pagar una cuota. <br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 * 
	 * @date 29/09/2016
	 * @version 1.0
	 * @param numeroCuota
	 * @param idPrestamo
	 * @return el pago.
	 *
	 */
	public Pago pagarCuota(int numeroCuota, long idPrestamo) {

		int ultimacuota = (int)ultimaCuotaPaga(idPrestamo);
		Prestamo pres = dao.encontrarPorId(Prestamo.class, idPrestamo);
		if (pres != null) {
			if (ultimacuota == 0 || ultimacuota + 1 == numeroCuota) {

				double pagointeres = pres.getInteres() * pres.getSaldo();
				double pagoCapital = pres.getValorCuota() - pagointeres;
				pres.setSaldo(pres.getSaldo() - pagoCapital);
				dao.actualizar(pres);
				Pago pago = new Pago(pres, numeroCuota, pagointeres, pagoCapital);
				pago.setSaldoActual(pres.getSaldo());
				dao.persistir(pago);
				return pago;
			} else {
				throw new ExcepcionNegocio("Cuota invalida, debe pagar la cuota:" + (ultimacuota + 1));
			}
		} else {
			throw new ExcepcionNegocio("Prestamo no existe");
		}

	}

	/**
	 * 
	 * Método que retorna las cuotas pagadas de un credito. <br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 * 
	 * @date 29/09/2016
	 * @version 1.0
	 * @param idPrestamo
	 * @return
	 *
	 */
	public List<Pago> listarPagosPrestamo(long idPrestamo) {
		// Pago.listartodos
		return dao.ejecutarNamedQuery("Pago.listartodos", idPrestamo);
	}

	
	public Prestamo buscar(long idPrestamo){
		return dao.encontrarPorId(Prestamo.class, idPrestamo);
	}
	
	
	
	private int ultimaCuotaPaga(long idPrestamo) {
		List<Integer> lista = dao.ejecutarNamedQuery("Pago.ultimacuota", idPrestamo);
		if (lista.get(0) == null) {
			return 0;
		} else {
			return lista.get(0);
		}
	}
}
