package gestionhotel.Metier;


import gestionhotel.DAO.InterfDevisDao;
import gestionhotel.entities.Devis;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.Metier
 *Classe:ImplMetierDevis*/

@Transactional
public class ImplMetierDevis implements InterMetierDevis{

	private final Logger LOG=Logger.getLogger("ImplMetierDevis");
	private InterfDevisDao daoDevis;
	
	
	
	//setters 
	public void setDaoDevis (InterfDevisDao daoDevis) {
		this.daoDevis = daoDevis;
		LOG.info("dao devis injected");
	}
	@Override
	public Devis addDevis(Devis d, Long idReservation) {
	return	daoDevis.addDevis(d, idReservation);
	
	}

	@Override
	public Devis getDevis(Long idDEvis) {
		return 	daoDevis.getDevis(idDEvis);
		
	}

	@Override
	public void updateDevis(Devis d) {
		daoDevis.updateDevis(d);
		
	}

	@Override
	public void deleteDevis(Long idDevis) {
		daoDevis.deleteDevis(idDevis);
		
	}

	@Override
	public void addProduitToDevis(Long idDevis, Long idProduit) {
	daoDevis.addProduitToDevis(idDevis, idProduit);
		
	}

	@Override
	public List<Devis> selectDevis() {
		return daoDevis.selectDevis();
	
	}

}
