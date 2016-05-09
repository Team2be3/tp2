package com.gestionhotel.gestionhotel;

/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.gestionhotel
 *Classe:ControllerProduit

 * */


import gestionhotel.Metier.InterMetierProduit;
import gestionhotel.entities.Produit;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerProduit {

	@Autowired
	private InterMetierProduit metierProduit;

	
	//Pour les dates
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	//Page du produit
		@RequestMapping(value="/produit")
		public String indexProduit(Model model){
			model.addAttribute("produits", metierProduit.selectProduit());
			model.addAttribute("produit", new Produit());
			
			return "Produit";
		}

	//Ajout d'un Produit
	@RequestMapping(value="/ajouterProduit")
	public String ajouterProduit(Model model,@ModelAttribute("produit") @Valid Produit pro,BindingResult resultat){
		
		model.addAttribute("produits", metierProduit.selectProduit());
		if(resultat.hasErrors()){
			return "Produit";
		}
		metierProduit.addProduit(pro);
    	return "redirect:produit";
	}
	
	//Ammène sur une page pour modifier le produit
	@RequestMapping(value="/produit/{idProduit}")
	public String modifierProduit(Model model,@PathVariable Long idProduit){

		model.addAttribute("produitM", metierProduit.getProduit(idProduit));
		model.addAttribute("produit", new Produit());
		return "ProduitUpdate";
	}
	
	//Modification de la produit
	@RequestMapping(value="/produit/modifierProduit")
	public String modifierProduit2(Model model,@ModelAttribute("produitM") @Valid Produit pro,BindingResult resultat){
		if(resultat.hasErrors()){
			return "ProduitUpdate";
		}
		metierProduit.updateProduit(pro);
    	return "redirect:/produitupdate";
	}
	
	//Suppression du produit
	@RequestMapping(value="/produit/delete/{idProduit}")
	public String supprimerProduit(Model model,@PathVariable Long idProduit){
		metierProduit.deleteProduit(idProduit);
		return "redirect:/produit";
	}
	
	
	
	//Recherche d'un produit par mot-clé
	@RequestMapping(value="/rechercherProduit")
	public String rechercherProduit (Model model, String motCle){
		model.addAttribute("produits", metierProduit.selectProduitParMc(motCle));
		model.addAttribute("produit",new Produit());
		return "Produit";
		}
	
}