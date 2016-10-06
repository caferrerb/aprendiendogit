package co.edu.eam.ingesoft.desarrollo.aerolinea.persistencia.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorConexionJDBC {

	public static Connection getConexion() throws SQLException {
		// 1.2 conectarse.
		// del paquete java.sql
		System.out.println("conectandose....");
		String url = "jdbc:mysql://localhost:3306/?????";
		String user = "????";
		String pass = "????";

		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}

}
