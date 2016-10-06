package testexamen;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrestamoRestTest {
	
	private static String saldo;
	@Test
	public void atestPagar() {
		try {
			ClientRequest request = new ClientRequest(Parametrizacion.URLBASE + "/prestamo/pagar");
			String input = "{\"numerocuota\":1,\"idprestamo\":\"" + SolicitudRestTest.idprestamo + "\"}";
			request.body("application/json", input);

			ClientResponse<String> response = request.post(String.class);

			String resp = getResponseAsString(response);
			System.out.println(resp);

			JSONParser parser = new JSONParser();
			JSONObject jsonobj = (JSONObject) parser.parse(resp);
			JSONObject objjson = (JSONObject) jsonobj.get("obj");
			
			Assert.assertEquals(SolicitudRestTest.idprestamo,
					(((JSONObject) objjson.get("prestamo")).get("numeroPrestamo")
							.toString()));
			Assert.assertNotNull((objjson.get("numeroCuota")));
			Assert.assertNotNull((objjson.get("pagointeres")));
			Assert.assertNotNull((objjson.get("pagoCapital")));
			saldo=((JSONObject)objjson.get("prestamo")).get("saldo").toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void btestbuscar() {
		try {
			ClientRequest request = new ClientRequest(
					Parametrizacion.URLBASE + "/prestamo/buscarprestamo?id=" + SolicitudRestTest.idprestamo);

			ClientResponse<String> response;

			response = request.get(String.class);

			String resp = getResponseAsString(response);
			System.out.println(resp);
			JSONParser parser = new JSONParser();
			JSONObject jsonobj = (JSONObject) parser.parse(resp);
			String saldoactual=(((JSONObject) jsonobj.get("obj")).get("saldo")).toString();
			Assert.assertEquals(saldoactual, saldo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			asser
			e.printStackTrace();
		}
	}

	private String getResponseAsString(ClientResponse<String> response) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new ByteArrayInputStream(response.getEntity().getBytes())));

		String output;
		String resp = "";
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {

			resp += output;
		}
		return resp;
	}

}
