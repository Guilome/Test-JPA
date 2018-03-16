package console;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author GOBERT Guillaume
 *
 */
public class TestJPA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.close();
	}
}
