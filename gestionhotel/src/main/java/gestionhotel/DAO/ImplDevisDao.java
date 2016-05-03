package gestionhotel.DAO;

import gestionhotel.entities.Devis;
import gestionhotel.entities.Produit;
import gestionhotel.entities.Reservation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/*Auteur(s):Shéhérazade 
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.DAO
 *Classe:ImplDevisDao
 *Version:1
 *Ref-UML:1
 *Sprint:1
 *Ref-UserStory:4
 * */

public class ImplDevisDao implements InterfDevisDao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Devis addDevis(Devis d, Long idReservation) {
		Reservation r= em.find(Reservation.class, idReservation);
		d.setReservation(r);
		em.persist(d);
		return d;
	}

	@Override
	public Devis getDevis(Long idDEvis) {
		Devis d= em.find(Devis.class, idDEvis);
		return d;
		
	}

	@Override
	public void updateDevis(Devis d) {
		em.merge(d);
		
	}

	@Override
	public void deleteDevis(Long idDevis) {
		Devis d= em.find(Devis.class, idDevis);
		em.remove(d);
		
	}

	@Override
	public void addProduitToDevis(Long idDevis, Long idProduit) {
	    Produit p= em.find(Produit.class, idProduit);
	    Devis d= em.find(Devis.class, idDevis);
	    d.getListeProduit().add(p);
	}

	@Override
	public List<Devis> selectDevis() {
		Query req = (Query) em.createQuery("from Devis");
		return req.getResultList();
			
	}

}
