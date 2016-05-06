package gestionhotel.Metier; 

import gestionhotel.DAO.InterReservationDAO;
import gestionhotel.entities.Chambre;
import gestionhotel.entities.Reservation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ImplReservationMetier implements InterReservationMetier{
	
	private final Logger LOG=Logger.getLogger("ImplemReservationMetier");
	private InterReservationDAO daoreservation;
	
	//setters 
	public void setDaoreservation(InterReservationDAO daoreservation) {
		this.daoreservation = daoreservation;
		LOG.info("dao reservation injected");
	}

	@Override
	public void addreservation(Reservation r, Long idClient, Long idEmploye) throws Exception {
		// TODO Auto-generated method stub
		daoreservation.addreservation(r, idClient, idEmploye);
		
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

	@Override
	public void addChamToReser(Long idReservation, Long idChambre) {
		daoreservation.addChamToReser(idReservation, idChambre);
	}

	@Override
	public List<Chambre> getlistechares(Long idReservation) {
		// TODO Auto-generated method stub
		return daoreservation.getlistechares(idReservation);
	}

	@Override
	public void deleteChamToReser(Long idReservation, Long idChambre) {
		daoreservation.deleteChamToReser(idReservation, idChambre);		
	}

}
