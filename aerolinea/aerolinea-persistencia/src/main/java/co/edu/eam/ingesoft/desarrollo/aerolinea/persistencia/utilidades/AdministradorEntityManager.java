package co.edu.eam.ingesoft.desarrollo.aerolinea.persistencia.utilidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdministradorEntityManager {

	private static EntityManager em;

	public static EntityManager getEntityManager() {

		if (em == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");

			em = emf.createEntityManager();
		}
		return em;

	}
}
