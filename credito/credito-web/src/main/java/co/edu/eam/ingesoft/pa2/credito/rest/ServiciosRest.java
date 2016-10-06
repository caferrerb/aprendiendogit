package co.edu.eam.ingesoft.pa2.credito.rest;


import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.credito.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.credito.model.Prestamo;
import co.edu.eam.ingesoft.pa2.credito.model.Solicitud;
import co.edu.eam.ingesoft.pa2.credito.service.SolicitudDTO;
import co.edu.eam.ingesoft.pa2.credito.service.SolicitudEJB;
import co.edu.eam.ingesoft.pa2.credito.service.WebSeviceEJB;

@Path("/solicitud")
public class ServiciosRest {

	@EJB
	private WebSeviceEJB serviceEJB;
	
	@EJB
	private SolicitudEJB solicitudEJB;
	
	
	@POST
	@Path("/score")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO consultarScore(@FormParam(value="ced")String cedula){
		double score = serviceEJB.consultarScore(cedula);
		return new RespuestaDTO(score);
	}
	
	@POST
	@Path("/solicitar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO solicitarPrestamo(SolicitudDTO s){
		
		
			Solicitud solicitud = solicitudEJB.solicitarCredito(s.getCedula(), 
                              s.getMonto(), s.getNumeroCuotas());
			if(solicitud!=null){
				return new RespuestaDTO(solicitud, "Se ejecuto correctamente","00");
			}else{
				return new RespuestaDTO(false, "Error","-1");
			}

	}
	
	@POST
	@Path("/aprobar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO aprobarSolicitudPrestamo(@FormParam(value="idsolicitud")long id){
		
		Prestamo p = solicitudEJB.aprobarSolicitud(id);
		if(p!=null){
			return new RespuestaDTO(p, "Se ejecuto correctamente","00");
		}else{
			return new RespuestaDTO(false, "Error","-1");
		}
			
	}
	
	
	@GET
	@Path("/solicitudesnoaprobadas")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarSolicitudNoAproda() {
		List<Solicitud> solicitud = solicitudEJB.solicitudesPorAprobar();
		if (solicitud != null) {
			return new RespuestaDTO(solicitud);
		} else {
			return new RespuestaDTO(false, "error", "-1");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
