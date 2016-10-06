package co.edu.eam.ingesoft.pa2.credito.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

import co.edu.eam.ingesoft.pa2.credito.entidades.Centralriego;
import co.edu.eam.ingesoft.pa2.credito.entidades.Ciudadano;
import co.edu.eam.ingesoft.pa2.credito.entidades.Consulta;
import co.edu.eam.ingesoft.pa2.credito.entidades.ConsultarCiudadano;
import co.edu.eam.ingesoft.pa2.credito.entidades.DatacreditoService;
import co.edu.eam.ingesoft.pa2.credito.entidades.RespuestaScoreDataCreditoDTO;
import co.edu.eam.ingesoft.pa2.credito.entidades.TipoDocEnum;

@LocalBean
@Stateless
public class WebSeviceEJB {
	
	public double consultarScore(String cedula){
		DatacreditoService cliente = new DatacreditoService();
		Centralriego servicio = cliente.getCentralriesgo();

		BindingProvider bp = (BindingProvider) servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/orderprocesor/centralriego?wsdl");


		RespuestaScoreDataCreditoDTO r = servicio.consultarCiudadano("bancolombia", 
				TipoDocEnum.CEDULA, cedula);
		
		if(r!=null){
			return r.getConsulta().getScore();
		}else{
			return -1;
		}

	}
	
	
	
	
	
	
	
}
