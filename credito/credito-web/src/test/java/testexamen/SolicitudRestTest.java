package testexamen;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SolicitudRestTest {

	public static String idsol;
	public static String idprestamo;

	@Test
	public void atestSolicitar() {
		try {
			ClientRequest request = new ClientRequest(Parametrizacion.URLBASE + "/solicitud/solicitar");
			String input = "{\"cedula\":100,\"monto\":\"1000\",\"numeroCuotas\":12}";
			request.body("application/json", input);

			ClientResponse<String> response = request.post(String.class);

			String resp = getResponseAsString(response);
			System.out.println(resp);
			
			JSONParser parser = new JSONParser();
			JSONObject jsonobj = (JSONObject) parser.parse(resp);
			Assert.assertEquals("100", (((JSONObject) ((JSONObject) jsonobj.get("obj")).get("cliente")).get("cedula")));
			Assert.assertEquals(1000.0, (((JSONObject) jsonobj.get("obj")).get("monto")));
			Assert.assertEquals(12l, (((JSONObject) jsonobj.get("obj")).get("plazo")));
			idsol = (((JSONObject) jsonobj.get("obj")).get("id")).toString();
			System.err.println("ID SOLICITUR:"+idsol);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Test
	public void btestAprobar() {
		try {
			ClientRequest request = new ClientRequest(Parametrizacion.URLBASE + "/solicitud/aprobar");
			String input = "idsolicitud=" + idsol;
			request.body("application/x-www-form-urlencoded", input);

			ClientResponse<String> response = request.post(String.class);

			String resp = getResponseAsString(response);
			System.out.println(resp);
			
			JSONParser parser = new JSONParser();
			JSONObject jsonobj = (JSONObject) parser.parse(resp);
			Assert.assertEquals("100", (((JSONObject) ((JSONObject) jsonobj.get("obj")).get("cliente")).get("cedula")));
			Assert.assertNotNull((((JSONObject) jsonobj.get("obj")).get("interes")));
			Assert.assertNotNull((((JSONObject) jsonobj.get("obj")).get("valorCuota")));
			idprestamo = (((JSONObject) jsonobj.get("obj")).get("numeroPrestamo")).toString();
			System.err.println("ID PRESTAMO:"+idprestamo);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Test
	public void ctestListar() {
		try {
			ClientRequest request = new ClientRequest(Parametrizacion.URLBASE + "/solicitud/solicitudesnoaprobadas");
			

			ClientResponse<String> response = request.get(String.class);

			String resp = getResponseAsString(response);
			System.out.println(resp);
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(resp);
			JSONArray array=(JSONArray)json.get("obj");
			boolean ok=false;
			for (Object object : array) {
				JSONObject jsonobj = (JSONObject)object;
				if(((JSONObject) jsonobj).get("id").toString().equals(idsol)){
					Assert.assertTrue(true);
					ok=true;
				}
			}
			if(!ok){
				Assert.assertTrue(false);
			}
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
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
