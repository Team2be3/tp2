package gestionhotel.Metier;


import gestionhotel.DAO.InterfFactureDao;
import gestionhotel.entities.Facture;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.Metier
 *Classe:ImplMetierFacture*/

@Transactional
public class ImplMetierFacture implements InterMetierFacture{

	private final Logger LOG=Logger.getLogger("ImplMetierFacture");
	private InterfFactureDao daoFacture;
	
	//setters  
	public void setDaoFacture(InterfFactureDao daoFacture) {
		this.daoFacture = daoFacture;
		LOG.info("dao facture injected");
	}
	
	@Override
	public Facture addFacture(Facture f, Long idDevis) {
		daoFacture.addFacture(f, idDevis);
		return f;
	}

	@Override
	public void updateFacture(Facture f) {
		daoFacture.updateFacture(f);
		
	}

	@Override
	public void deleteFacturet(Long idFacture) {
		daoFacture.deleteFacturet(idFacture);
		
	}

	@Override
	public Facture getFacture(Long idFacture) {
		return daoFacture.getFacture(idFacture);
		
	}

	@Override
	public List<Facture> selectFacture() {
	return daoFacture.selectFacture();
	}

}
