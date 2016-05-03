package gestionhotel.DAO;


/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.DAO
 *Classe:ImplFacture
 *Version:1
 *Ref-UML:1
 *Sprint:1
 *Ref-UserStory:4
 * */

import gestionhotel.entities.Devis;
import gestionhotel.entities.Facture;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ImplFactureDao implements InterfFactureDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Facture addFacture(Facture f, Long idDevis) {
		Devis d = em.find(Devis.class, idDevis);
		f.setDevis(d);
		em.persist(f);
		return f;

	}

	@Override
	public void updateFacture(Facture f) {
		em.merge(f);

	}

	@Override
	public void deleteFacturet(Long idFacture) {
		Facture f = em.find(Facture.class, idFacture);
		em.remove(f);

	}

	@Override
	public Facture getFacture(Long idFacture) {
		Facture f = em.find(Facture.class, idFacture);
		return f;
	}

	@Override
	public List<Facture> selectFacture() {
		Query req = (Query) em.createQuery("from Facture");
		return req.getResultList();

	}

}
