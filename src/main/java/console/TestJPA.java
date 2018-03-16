package console;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Client;
import model.Emprunt;
import model.Livre;

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

		// Retrouver un Livre par son Id
		System.out.println(
				"____________________________________________________________________________________________");
		Livre livreId = em.find(Livre.class, 4);
		System.out.println(livreId.getTitre());

		// Afficher un livrr par la requete SELECT
		System.out.println(
				"____________________________________________________________________________________________");
		Livre livre = null;

		TypedQuery<Livre> livreQuery = em.createQuery("select l from Livre l where l.titre=:titreLivre", Livre.class);
		livreQuery.setParameter("titreLivre", "Apprendre à parler aux animaux");

		if (livreQuery.getMaxResults() > 1) {
			livre = livreQuery.getResultList().get(0);
		}
		livre = livreQuery.getSingleResult();

		System.out.println(livre.getTitre() + " écrit par " + livre.getAuteur());

		// Emprunt / Livres
		System.out.println(
				"____________________________________________________________________________________________");
		Emprunt emprunt = null;

		TypedQuery<Emprunt> EmpruntQuery = em.createQuery("select e from Emprunt e where e.id=:idEmprunt",
				Emprunt.class);
		EmpruntQuery.setParameter("idEmprunt", 1);

		if (EmpruntQuery.getMaxResults() > 1) {
			emprunt = EmpruntQuery.getResultList().get(0);
		}
		emprunt = EmpruntQuery.getSingleResult();
		System.out.println("");
		System.out.println("Emprunt n°" + emprunt.getId());
		for (Livre livreE : emprunt.getLivres()) {
			System.out.println(livreE.getTitre() + " écrit par " + livreE.getAuteur());
		}

		// Client / Emprunts
		System.out.println(
				"____________________________________________________________________________________________");
		Client client = null;
		String affichage = null;

		TypedQuery<Client> clientQuery = em.createQuery("select c from Client c where c.id=:idClient", Client.class);
		clientQuery.setParameter("idClient", 1);

		if (clientQuery.getMaxResults() > 1) {
			client = clientQuery.getResultList().get(0);
		}
		client = clientQuery.getSingleResult();
		System.out.println("");
		System.out.println(client.getPrenom() + " " + client.getNom() + " (  Nbre emprunts : "
				+ client.getEmprunts().size() + " )");
		for (Emprunt empruntC : client.getEmprunts()) {
			affichage = "Emprunt n°" + empruntC.getId() + " (" + empruntC.getDateDebut() + " | " + empruntC.getDateFin()
					+ ")";
			if (empruntC.getDateFin() == null) {
				affichage += " => Delai : " + empruntC.getDelai() + " jours";
			}
			System.out.println(affichage);

			for (Livre livreEC : empruntC.getLivres()) {
				System.out.println("- " + livreEC.getTitre() + " écrit par " + livreEC.getAuteur());
			}
			System.out.println("");
		}

		em.close();
		entityManagerFactory.close();
	}
}
