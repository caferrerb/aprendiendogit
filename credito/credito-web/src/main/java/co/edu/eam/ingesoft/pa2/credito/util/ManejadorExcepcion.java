package co.edu.eam.ingesoft.pa2.credito.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import co.edu.eam.ingesoft.pa2.credito.dto.RespuestaDTO;

/**
 * 
 * Clase responsable de manejar las excepciones en los servicios. <br>
 * 
 * @author INDRA <br>
 *         Camilo Andres Ferrer Bustos<br>
 *         caferrer@eservicios.indracompany.com<br>
 * 
 * @date 22/09/2016
 * @version 1.0
 */
@Provider
public class ManejadorExcepcion implements ExceptionMapper<Throwable> {

	/**
	 * @param exc:
	 *            Excepcion que paso
	 */
	@Override
	public Response toResponse(Throwable exc) {

		if (exc instanceof ExcepcionNegocio) {
			ExcepcionNegocio excNeg = (ExcepcionNegocio) exc;
			RespuestaDTO dto = new RespuestaDTO(null, excNeg.getMessage(), "-1");
			exc.printStackTrace();
			return Response.status(500).entity(dto).build();
		} else {
			RespuestaDTO dto = new RespuestaDTO(null, "Error inesperado", "-2");
			exc.printStackTrace();
			return Response.status(500).entity(dto).build();
		}

	}

}
