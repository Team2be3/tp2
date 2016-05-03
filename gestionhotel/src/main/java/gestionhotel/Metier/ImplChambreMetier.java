package gestionhotel.Metier; 

import gestionhotel.DAO.InterChambreDao;
import gestionhotel.entities.Chambre;
import gestionhotel.entities.Reservation;

import java.util.List;

import org.apache.log4j.Logger;

public class ImplChambreMetier implements InterChambreMetier{
	
	private final Logger LOG=Logger.getLogger("ImplemChambreMetier");
	private InterChambreDao daochambre;
	
	
	//setters
	
	public InterChambreDao getDaochambre() {
		return daochambre;
	}

	public void setDaochambre(InterChambreDao daochambre) {
		this.daochambre = daochambre;
	}

	public Logger getLOG() {
		return LOG;
	}

	@Override
	public void addchambre(Chambre c) {
		// TODO Auto-generated method stub
		daochambre.addchambre(c);
		
	}

	

	@Override
	public void deletechambre(Long idChambre) {
		// TODO Auto-generated method stub
		daochambre.deletechambre(idChambre);
		
	}

	@Override
	public void updatechambre(Chambre c) {
		// TODO Auto-generated method stub
		daochambre.updatechambre(c);
		
	}

	@Override
	public Chambre getChambre(Long idChambre) {
		// TODO Auto-generated method stub
		return daochambre.getChambre(idChambre);
	}

	@Override
	public List<Chambre> getlistechambres() {
		// TODO Auto-generated method stub
		return daochambre.getlistechambres();
	}

	@Override
	public List<Reservation> getlistereservchambre(Long idChambre) {
		// TODO Auto-generated method stub
		return daochambre.getlistereservchambre(idChambre);
	}

}
