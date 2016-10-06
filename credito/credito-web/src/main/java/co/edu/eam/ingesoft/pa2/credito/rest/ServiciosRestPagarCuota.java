package co.edu.eam.ingesoft.pa2.credito.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.credito.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.credito.model.Pago;
import co.edu.eam.ingesoft.pa2.credito.model.Prestamo;
import co.edu.eam.ingesoft.pa2.credito.model.Solicitud;
import co.edu.eam.ingesoft.pa2.credito.service.PrestamoDTO;
import co.edu.eam.ingesoft.pa2.credito.service.PrestamoEJB;
import co.edu.eam.ingesoft.pa2.credito.service.SolicitudDTO;

@Path("/prestamo")
public class ServiciosRestPagarCuota {

	@EJB
	private PrestamoEJB prestamoEJB;
	
	@POST
	@Path("/pagar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO pagarCuota(PrestamoDTO p){
		
		Pago pago = prestamoEJB.pagarCuota(p.getNumerocuota(), p.getIdprestamo());
		if(pago!=null){
			return new RespuestaDTO(pago);
		}else{
			return new RespuestaDTO(false, "Error", "-1");
		}

	}
	
	
	@POST
	@Path("/buscarprestamo")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO buscarPrestamo(@QueryParam(value="id")long id) {
		Prestamo prestamo = prestamoEJB.buscar(id);
		if (prestamo != null) {
			return new RespuestaDTO(prestamo);
		} else {
			return new RespuestaDTO(false, "No existe el prestamo", "-1");
		}
	}
	
}
