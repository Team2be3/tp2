package gestionhotel.DAO;

import java.util.List;

import gestionhotel.entities.Reservation;

public interface InterReservationDAO {
	
	public void addreservation(Reservation r, Long idClient, Long idEmploye, Long idChambre);
	public void deletereservation(Long idReservation);
	public void updatereservation(Reservation r);
	public Reservation getreservation(Long idReservation);
	public List<Reservation> getlistereservations();

}
