package gestionhotel.REST;

import java.util.List;

import gestionhotel.Metier.InterMetierProduit;
import gestionhotel.entities.Client;
import gestionhotel.entities.Produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProduitRest {
	@Autowired
	private InterMetierProduit metierProduit;
	

	@RequestMapping(value="/ajouterProduit")
	private void addProduit (@RequestBody Produit p) {
		metierProduit.addProduit(p);

	}
	
	@RequestMapping(value="/produit/delete/{idProduit}",method=RequestMethod.DELETE)
	public void suppProduit(@PathVariable Long idProduit) {
		metierProduit.deleteProduit(idProduit);
	}
	
	@RequestMapping(value="/produit/modifierProduit}", method=RequestMethod.PUT)
	public void updateProduit(Produit p){
		metierProduit.updateProduit (p);
	}
	
	
	@RequestMapping(value="/produit", method=RequestMethod.GET)
	public List<Produit> selectProduit(){
		return metierProduit.selectProduit();
	}
	
	@RequestMapping(value="/rechercherProduit", method=RequestMethod.GET)
	public List<Produit> selectProduitParMc(@PathVariable String mc){
		return metierProduit.selectProduitParMc(mc);
	}
}
