package gestionhotel.DAO;

import java.util.List;

import gestionhotel.entities.Chambre;

public interface InterChambreDao {
	
	public void addchambre(Chambre c);
	public void deletechambre(Long idChambre);
	public void updatechambre(Chambre c);
	public Chambre getChambre(Long idChambre);
	public List<Chambre> getlistechambres();

}
