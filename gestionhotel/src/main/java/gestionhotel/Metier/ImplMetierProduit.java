package gestionhotel.Metier;


import gestionhotel.DAO.InterfProduitDao;
import gestionhotel.entities.Produit;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.Metier
 *Classe:ImplMetierProduit*/
@Transactional
public class ImplMetierProduit implements InterMetierProduit {
	
	private final Logger LOG=Logger.getLogger("ImplMetierProduit");
	private InterfProduitDao daoProduit;
	
	//setters  
	public void setDaoProduit(InterfProduitDao daoProduit) {
		this.daoProduit = daoProduit;
		LOG.info("dao produit injected");
	}

	@Override
	public Produit addProduit(Produit p) {
		daoProduit.addProduit(p);
		return p;
	}

	@Override
	public void updateProduit(Produit p) {
		daoProduit.updateProduit(p);
		
	}

	@Override
	public void deleteProduit(Long idProduit) {
		daoProduit.deleteProduit(idProduit);
		
	}

	@Override
	public Produit getProduit(Long idProduit) {
		return daoProduit.getProduit(idProduit);
		
	}

	@Override
	public List<Produit> selectProduit() {
		return daoProduit.selectProduit();
	
	}

	@Override
	public List<Produit> selectProduitParMc(String mc) {
		return daoProduit.selectProduitParMc(mc);
	}

}
