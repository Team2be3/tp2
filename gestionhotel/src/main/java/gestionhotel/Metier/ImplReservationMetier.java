package gestionhotel.Metier; 

import gestionhotel.DAO.InterReservationDAO;
import gestionhotel.entities.Reservation;

import java.util.List;

import org.apache.log4j.Logger;

public class ImplReservationMetier implements InterReservationMetier{
	
	private final Logger LOG=Logger.getLogger("ImplemReservationMetier");
	private InterReservationDAO daoreservation;

	@Override
	public void addreservation(Reservation r, Long idClient, Long idEmploye,
			Long idChambre) {
		// TODO Auto-generated method stub
		daoreservation.addreservation(r, idClient, idEmploye, idChambre);
		
	}

	@Override
	public void deletereservation(Long idReservation) {
		// TODO Auto-generated method stub
		daoreservation.deletereservation(idReservation);
		
	}

	@Override
	public void updatereservation(Reservation r) {
		// TODO Auto-generated method stub
		daoreservation.updatereservation(r);
		
	}

	@Override
	public Reservation getreservation(Long idReservation) {
		// TODO Auto-generated method stub
		return daoreservation.getreservation(idReservation);
	}

	@Override
	public List<Reservation> getlistereservations() {
		// TODO Auto-generated method stub
		return daoreservation.getlistereservations();
	}

}
