package com.gestionhotel.gestionhotel;

/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.gestionhotel
 *Classe:ControllerProduit

 * */

import gestionhotel.Metier.InterChambreMetier;
import gestionhotel.Metier.InterClientMetier;
import gestionhotel.Metier.InterEmployeMetier;
import gestionhotel.Metier.InterMetierProduit;
import gestionhotel.Metier.InterReservationMetier;
import gestionhotel.entities.Chambre;
import gestionhotel.entities.Client;
import gestionhotel.entities.ExceptionHotel;
import gestionhotel.entities.Produit;
import gestionhotel.entities.Reservation;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

	//Ajout d'un Produit
	@RequestMapping(value="/ajouterProduit")
	public String ajouterProduit(Model model,@ModelAttribute("produit") @Valid Produit pro,BindingResult resultat){
		
		model.addAttribute("produit", metierProduit.selectProduit());
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
	
	//Renvoie du produit grace à l'identifiant
	@RequestMapping(value="/produit/get/{idProduit}")
	public String recupProduit(Model model,@PathVariable Long idProduit){
		metierProduit.getProduit(idProduit);
		return "redirect:/produit";
	}
	
	
	//Recherche d'un produit par mot-clé
	@RequestMapping(value="/rechercherProduit")
	public String rechercherProduit (Model model, String motCle){
		model.addAttribute("Produit", metierProduit.selectProduitParMc(motCle));
		model.addAttribute("Produit",new Produit());
		return "Produit";
		}
	
}