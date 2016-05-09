package com.gestionhotel.gestionhotel;

import gestionhotel.Metier.InterChambreMetier;
import gestionhotel.Metier.InterClientMetier;
import gestionhotel.Metier.InterEmployeMetier;
import gestionhotel.Metier.InterMetierDevis;
import gestionhotel.Metier.InterMetierFacture;
import gestionhotel.Metier.InterMetierProduit;
import gestionhotel.Metier.InterReservationMetier;
import gestionhotel.entities.Chambre;
import gestionhotel.entities.ExceptionHotel;
import gestionhotel.entities.Facture;
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

public class ControllerFacture {

	@Autowired
	private InterMetierFacture metierFacture;
	@Autowired
	private InterMetierDevis metierDevis;

	
	//Pour les dates
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	//Ajout d'une FActure
	@RequestMapping(value="/ajouterFacture")
	public String ajouterFacture(Model model,@ModelAttribute("fact")@PathVariable Long idDEvis, @Valid Facture fra,BindingResult resultat){
		
		model.addAttribute("fact", metierFacture.selectFacture());
		model.addAttribute("devis", metierDevis.selectDevis());
		model.addAttribute("devis", metierDevis.getDevis(idDEvis));
	
	
		if(resultat.hasErrors()){
			return "Devis";
		}
		try {
			metierFacture.addFacture(fra, idDEvis);
		} catch (Exception e) {
			ExceptionHotel eh=new ExceptionHotel();
			eh.setException(e.getMessage());
			model.addAttribute("exc", eh);
			return "Facture";
		}
    	return "redirect:facture";
	}
	
	//Ammène sur une page pour modifier la facture
	@RequestMapping(value="/facture/{idFacture}")
	public String modifierFacture(Model model,@PathVariable Long idFacture){

		model.addAttribute("factureM", metierFacture.getFacture(idFacture));
		return "FactureUpdate";
	}
	
	//Modification facture
	@RequestMapping(value="/facture/modifierFacture")
	public String modifierFacture2(Model model,@ModelAttribute("factureM") @Valid Facture fact,BindingResult resultat){
		if(resultat.hasErrors()){
			return "FactureUpdate";
		}
		metierFacture.updateFacture(fact);
    	return "redirect:/factureupdate";
	}
	
	//Suppression du facture
	@RequestMapping(value="/facture/delete/{idFacture}")
	public String supprimerFacture(Model model,@PathVariable Long idFacture){
		metierFacture.deleteFacturet(idFacture);
		return "redirect:/factureS";
	}

	
	
	
}