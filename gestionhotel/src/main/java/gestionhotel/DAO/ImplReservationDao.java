package gestionhotel.DAO;

import gestionhotel.entities.Chambre;
import gestionhotel.entities.Client;
import gestionhotel.entities.Employe;
import gestionhotel.entities.Reservation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/*Auteur: Valérian THOMAS
 * nom: ImplReservationDao
 *date: 03/05/2016
 *Package:gestionhotel.DAO
 *Interface : InterReservationDAO
 *version:1
 * 
 * */

public class ImplReservationDao implements InterReservationDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addreservation(Reservation r, Long idClient, Long idEmploye,
			Long idChambre) {
		// TODO Auto-generated method stub
		Client c = em.find(Client.class, idClient);
		Employe e = em.find(Employe.class, idEmploye);
		Chambre ch = em.find(Chambre.class, idChambre);
		r.setClient(c);
		r.setEmploye(e);
		r.getListechambre().add(ch);
		em.persist(r);		
		
	}

	@Override
	public void deletereservation(Long idReservation) {
		// TODO Auto-generated method stub
		Reservation r = em.find(Reservation.class, idReservation);
		em.remove(r);
		
	}

	@Override
	public void updatereservation(Reservation r) {
		// TODO Auto-generated method stub
		em.merge(r);
		
	}

	@Override
	public Reservation getreservation(Long idReservation) {
		// TODO Auto-generated method stub
		Reservation r = em.find(Reservation.class, idReservation);
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> getlistereservations() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Reservation r");
		return query.getResultList();
	}

	@Override
	public void addChamToReser(Long idReservation, Long idChambre) {
		Reservation r=em.find(Reservation.class, idReservation);
		Chambre c=em.find(Chambre.class, idChambre);
		r.getListechambre().add(c);
		c.getListereservation().add(r);
	}

}
