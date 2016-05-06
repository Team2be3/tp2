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
	public void addreservation(Reservation r, Long idClient, Long idEmploye) throws Exception {
		// TODO Auto-generated method stub
		if(r.getDateFin().getTime()<r.getDateDebut().getTime())throw new Exception("La date de fin doit être plus grande ou égale que la date de debut");
		Client c = em.find(Client.class, idClient);
		Employe e = em.find(Employe.class, idEmploye);
		r.setClient(c);
		r.setEmploye(e);
		em.persist(r);
	}

	@Override
	public void deletereservation(Long idReservation) {
		Reservation r = em.find(Reservation.class, idReservation);
		for (Chambre ch : r.getListechambre()) {
			ch.getListereservation().remove(r);
		}
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

	@Override
	public List<Chambre> getlistechares(Long idReservation) {
		Query query = em.createQuery("select r.listechambre from Reservation r where r.idReservation= :x");
		query.setParameter("x", idReservation);
		return query.getResultList();
	}

	@Override
	public void deleteChamToReser(Long idReservation, Long idChambre) {
		Reservation r=em.find(Reservation.class, idReservation);
		Chambre c=em.find(Chambre.class, idChambre);
		r.getListechambre().remove(c);
		c.getListereservation().remove(r);
	}

}
