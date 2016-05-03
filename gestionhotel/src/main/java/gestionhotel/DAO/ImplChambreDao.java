package gestionhotel.DAO;

/*Auteur: Valérian THOMAS
 * nom: ImplChambreDao
 *date: 03/05/2016
 *Package:gestionhotel.DAO
 *Interface : InterChambreDao
 *version:1
 * 
 * */

import gestionhotel.entities.Chambre;
import gestionhotel.entities.Reservation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ImplChambreDao implements InterChambreDao{
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addchambre(Chambre c) {
		// TODO Auto-generated method stub
		
		em.persist(c);
		
	}

	@Override
	public void deletechambre(Long idChambre) {
		// TODO Auto-generated method stub
		Chambre c = em.find(Chambre.class, idChambre);
		em.remove(c);	
		
	}

	@Override
	public void updatechambre(Chambre c) {
		// TODO Auto-generated method stub
		em.merge(c);
		
		
	}

	@Override
	public Chambre getChambre(Long idChambre) {
		// TODO Auto-generated method stub
		Chambre c = em.find(Chambre.class, idChambre);
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chambre> getlistechambres() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Chambre c");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> getlistereservchambre(Long idChambre) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select c.listereservation from Chambre c where c.idChambre= :x");
		query.setParameter("x", idChambre);
		return query.getResultList();
	}
	
	

}
