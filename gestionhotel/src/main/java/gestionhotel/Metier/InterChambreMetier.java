package gestionhotel.Metier;

import gestionhotel.entities.Chambre;
import gestionhotel.entities.Reservation;

import java.util.List;

public interface InterChambreMetier {
	
	public void addchambre(Chambre c);
	public void deletechambre(Long idChambre);
	public void updatechambre(Chambre c);
	public Chambre getChambre(Long idChambre);
	public List<Chambre> getlistechambres();
	public List<Reservation> getlistereservchambre(Long idChambre);

}
