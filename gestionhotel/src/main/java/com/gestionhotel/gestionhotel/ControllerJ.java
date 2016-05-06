package com.gestionhotel.gestionhotel;

/*Auteur:Dubuc Jérémy
 *nom Projet:gestionhotel
 *date:05/05/2016
 *Package:com.gestionhotel.gestionhotel
 *Class:Client
 *Controlleur pour les chambres et réservations
 * */

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import gestionhotel.Metier.InterChambreMetier;
import gestionhotel.Metier.InterClientMetier;
import gestionhotel.Metier.InterEmployeMetier;
import gestionhotel.Metier.InterReservationMetier;
import gestionhotel.entities.Chambre;
import gestionhotel.entities.ExceptionHotel;
import gestionhotel.entities.Reservation;

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
public class ControllerJ {
	
	@Autowired
	private InterChambreMetier metierChambre;
	@Autowired
	private InterReservationMetier metierReservation;
	@Autowired
	private InterClientMetier metierClient;
	@Autowired
	private InterEmployeMetier metierEmploye;
	
	//Pour les dates
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	/////////////////////
	//Pour les chambres//
	/////////////////////
	
	//A enlever
	@RequestMapping(value="/")
	public String indexChambreI(Model model){
		model.addAttribute("chambres", metierChambre.getlistechambres());
		model.addAttribute("chambre", new Chambre());
		return "Chambre";
	}
	
	//Page de la chambre
	@RequestMapping(value="/chambre")
	public String indexChambre(Model model){
		model.addAttribute("chambres", metierChambre.getlistechambres());
		model.addAttribute("chambre", new Chambre());
		return "Chambre";
	}
	
	//Ajout d'une chambre
	@RequestMapping(value="/ajouterChambre")
	public String ajouterChambre(Model model,@ModelAttribute("chambre") @Valid Chambre ch,BindingResult resultat){
		
		model.addAttribute("chambres", metierChambre.getlistechambres());
		if(resultat.hasErrors()){
			return "Chambre";
		}
		metierChambre.addchambre(ch);
    	return "redirect:chambre";
	}
	
	//Ammène sur une page pour modifier la chambre
	@RequestMapping(value="/chambre/{idChambre}")
	public String modifierChambre(Model model,@PathVariable Long idChambre){

		model.addAttribute("chambreM", metierChambre.getChambre(idChambre));
		return "ChambreUpdate";
	}
	
	//Modification de la chambre
	@RequestMapping(value="/chambre/modifierChambre")
	public String modifierChambre2(Model model,@ModelAttribute("chambreM") @Valid Chambre ch,BindingResult resultat){
		if(resultat.hasErrors()){
			return "ChambreUpdate";
		}
		metierChambre.updatechambre(ch);
    	return "redirect:/chambre";
	}
	
	//Suppression de la chambre
	@RequestMapping(value="/chambre/delete/{idChambre}")
	public String supprimerChambre(Model model,@PathVariable Long idChambre){
		metierChambre.deletechambre(idChambre);
		return "redirect:/chambre";
	}
	
	/////////////////////////
	//Pour les reservations//
	/////////////////////////
	
	//Page de la réservation
	@RequestMapping(value="/reservation")
	public String indexReservation(Model model){
		model.addAttribute("reservations", metierReservation.getlistereservations());
		model.addAttribute("clients", metierClient.getListClient());
		model.addAttribute("employes", metierEmploye.getListEmploye());
		model.addAttribute("reser", new Reservation());
		
		return "Reservation";
	}
	
	//Ajout d'une réservation, chambre à rajouter après coup
	@RequestMapping(value="/ajouterReservation")
	public String ajouterReservation(Model model,@ModelAttribute("reser") @Valid Reservation r, BindingResult resultat, Long idClient, Long idEmploye){
		model.addAttribute("reservations", metierReservation.getlistereservations());
		model.addAttribute("clients", metierClient.getListClient());
		model.addAttribute("employes", metierEmploye.getListEmploye());
		
		if(resultat.hasErrors()){
			return "Reservation";
		}
		try {
			metierReservation.addreservation(r, idClient, idEmploye);
		} catch (Exception e) {
			ExceptionHotel eh=new ExceptionHotel();
			eh.setException(e.getMessage());
			model.addAttribute("exc", eh);
			return "Reservation";
		}
    	return "redirect:reservation";
	}
	
	//Amène sur une page pour modifier la réservation
	@RequestMapping(value="/reservation/update/{idReservation}")
	public String modifierReservation(Model model,@PathVariable Long idReservation){
		model.addAttribute("reserM", metierReservation.getreservation(idReservation));
		return "ReservationUpdate";
		
	}
	
	//Modification de l'état de la réservation uniquement car les dates ne peuvent être changer à cause de problème sur les chambres possibles
	@RequestMapping(value="/reservation/update/etape2/{idReservation}")
	public String modifierReservation2(Model model,@ModelAttribute("reserM") @Valid Reservation r,BindingResult resultat,@PathVariable Long idReservation){
		if(resultat.hasErrors()){
			return "ReservationUpdate";
		}
		Reservation r2=metierReservation.getreservation(idReservation);
		r2.setEtatReservation(r.getEtatReservation());
		metierReservation.updatereservation(r2);;
    	return "redirect:/reservation";
	}
	
	
	//Suppression d'une réservation
	@RequestMapping(value="/reservation/delete/{idReservation}")
	public String supprimerReservation(Model model,@PathVariable Long idReservation){
		metierReservation.deletereservation(idReservation);
		return "redirect:/reservation";
	}
	
	//Amène sur la page avec liste des chambres sur la réservation et les chambres que l'on peut réserver en plus sur la plage horraire
	@RequestMapping(value="/reservation/chambres/{idReservation}")
	public String listChambreReservation(Model model,@PathVariable Long idReservation){
		Reservation r=metierReservation.getreservation(idReservation);
		model.addAttribute("reservation", r);
		model.addAttribute("chares", metierReservation.getlistechares(idReservation));
		model.addAttribute("dispo", metierChambre.dispochambre(r.getDateDebut(), r.getDateFin()));
    	return "ReservationChambres";
	}
	
	//Fonction pour ajouter une chambre à la réservation
	@RequestMapping(value="/reservation/{idReservation}/{idChambre}")
	public String ajoutChambreReservation(Model model,@PathVariable Long idReservation,@PathVariable Long idChambre){
		metierReservation.addChamToReser(idReservation, idChambre);
		Reservation r=metierReservation.getreservation(idReservation);
		model.addAttribute("reservation", r);
		model.addAttribute("chares", metierReservation.getlistechares(idReservation));
		model.addAttribute("dispo", metierChambre.dispochambre(r.getDateDebut(), r.getDateFin()));
    	return "redirect:/reservation/chambres/{idReservation}";
	}
	
	//Fonction pour elever une chambre à la réservation
		@RequestMapping(value="/reservation/delete/{idReservation}/{idChambre}")
		public String enleverChambreReservation(Model model,@PathVariable Long idReservation,@PathVariable Long idChambre){
			metierReservation.deleteChamToReser(idReservation, idChambre);
			Reservation r=metierReservation.getreservation(idReservation);
			model.addAttribute("reservation", r);
			model.addAttribute("chares", metierReservation.getlistechares(idReservation));
			model.addAttribute("dispo", metierChambre.dispochambre(r.getDateDebut(), r.getDateFin()));
	    	return "redirect:/reservation/chambres/{idReservation}";
		}
}
