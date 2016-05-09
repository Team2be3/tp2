package com.gestionhotel.gestionhotel;

import gestionhotel.Metier.InterChambreMetier;
import gestionhotel.Metier.InterClientMetier;
import gestionhotel.Metier.InterEmployeMetier;
import gestionhotel.Metier.InterMetierDevis;
import gestionhotel.Metier.InterMetierProduit;
import gestionhotel.Metier.InterReservationMetier;
import gestionhotel.entities.Chambre;
import gestionhotel.entities.Devis;
import gestionhotel.entities.ExceptionHotel;
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

public class ControllerDevis {

	@Autowired
	private InterMetierDevis metierDevis;
	@Autowired
	private InterReservationMetier metierReservation;
	@Autowired
	private InterMetierProduit metierProduit;

	
	//Pour les dates
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	//Page du devis
	@RequestMapping(value="/devis")
	public String indexDevis(Model model){
		model.addAttribute("devis", metierDevis.selectDevis());
		model.addAttribute("reservation", metierReservation.getlistereservations());
		model.addAttribute("produit", metierProduit.selectProduit());
		model.addAttribute("dev", new Devis());
		
		return "Devis";
	}
	
	//Ajout d'un devis
	@RequestMapping(value="/ajouterDevis")
	public String ajouterDevis(Model model,@ModelAttribute("dev") @Valid Devis d, BindingResult resultat, Long idDevis, Long idReservation){
		model.addAttribute("devis", metierDevis.selectDevis());
		model.addAttribute("reservation", metierReservation.getlistereservations());
		model.addAttribute("produit", metierProduit.selectProduit());
		
		if(resultat.hasErrors()){
			return "Devis";
		}
		try {
			metierDevis.addDevis(d, idReservation);
		} catch (Exception e) {
			ExceptionHotel eh=new ExceptionHotel();
			eh.setException(e.getMessage());
			model.addAttribute("exc", eh);
			return "Devis";
		}
    	return "redirect:devis";
	}
	
	//Amène sur une page pour modifier le Devis
	@RequestMapping(value="/devis/update/{idDevis}")
	public String modifierDevis(Model model,@PathVariable Long idDevis){
		model.addAttribute("devM", metierDevis.getDevis(idDevis));
		return "DevisUpdate";
		
	}
	//Suppression devis
		@RequestMapping(value="/devis/delete/{idDevis}")
		public String supprimerDevis(Model model,@ModelAttribute("devS")@PathVariable Long idDevis){
			metierDevis.deleteDevis(idDevis);
			return "redirect:/devis";
		}
		
		//>Calculer devis
				@RequestMapping(value="/calculerDevis")
				public String calculerDevis(Model model,@ModelAttribute("devM")@PathVariable Long idDevis){
					metierDevis.prixDevis(idDevis);
					return "redirect:/devis";
				}
		
}