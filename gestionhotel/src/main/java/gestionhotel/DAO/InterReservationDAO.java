package gestionhotel.DAO;

import java.util.List;

import gestionhotel.entities.Chambre;
import gestionhotel.entities.Reservation;

public interface InterReservationDAO {
	
	public void addreservation(Reservation r, Long idClient, Long idEmploye) throws Exception;
	public void deletereservation(Long idReservation);
	public void updatereservation(Reservation r);
	public Reservation getreservation(Long idReservation);
	public List<Reservation> getlistereservations();
	public void addChamToReser(Long idReservation, Long idChambre);
	public List<Chambre> getlistechares(Long idReservation);
	public void deleteChamToReser(Long idReservation, Long idChambre);

}
