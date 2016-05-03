package gestionhotel.Metier;

import gestionhotel.entities.Reservation;

import java.util.List;

public interface InterReservationMetier {
	
	public void addreservation(Reservation r, Long idClient, Long idEmploye, Long idChambre);
	public void deletereservation(Long idReservation);
	public void updatereservation(Reservation r);
	public Reservation getreservation(Long idReservation);
	public List<Reservation> getlistereservations();

}
