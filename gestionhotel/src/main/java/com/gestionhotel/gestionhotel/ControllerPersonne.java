package com.gestionhotel.gestionhotel;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import gestionhotel.Metier.InterClientMetier;
import gestionhotel.entities.Client;
import gestionhotel.Metier.InterEmployeMetier;
import gestionhotel.entities.Employe;

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
public class ControllerPersonne {
	
	@Autowired
	private InterClientMetier metier;
	private InterEmployeMetier metier1;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	//************************Pour les clients************************
	
	//Page d'accueil Personne
	@RequestMapping(value="/Personne")
	public String homePersonne(Model model){
		model.addAttribute("Clients", metier.getListClient());
		model.addAttribute("Client",new Client());
		//model.addAttribute("Employes", metier1.getListEmploye());
		return "Personne";
	}
	
	//Ajout d'un client
	@RequestMapping(value = "/addclient")
	public String addClient(Model model, @ModelAttribute("Client") @Valid Client c, BindingResult resultat){
		model.addAttribute("Clients", metier.getListClient());
		if (resultat.hasErrors()){
			return "Personne";
		}
		metier.addClient(c);
		return "redirect:Personne";
	}
	
	
	//Suppression d'un client
	@RequestMapping(value="/deleteclient/{idPersonne}")
	public String deleteClient(Model model, @PathVariable Long idPersonne){
		metier.deleteClient(idPersonne);
		model.addAttribute("Clients", metier.getListClient());
		return "redirect:/Personne";
	}
	
	
	//Recherche d'un client par mot-clé
	@RequestMapping(value="/rechercherclient")
	public String rechercherClient (Model model, String mc){
		model.addAttribute("Clients", metier.getListCliMc(mc));
		model.addAttribute("Client",new Client());
		return "Personne";
		}
	
	
	//Modification des données d'un client
	@RequestMapping(value="/updateclient/{idPersonne}")
	public String updateClient(Model model, @PathVariable Long idPersonne){
		model.addAttribute("clientup", metier.getClient(idPersonne));
		return "PersonneUpdate";
	}
	
	
	@RequestMapping(value="/updateclient/{idPersonne}/done")
	public String updateClient2 (Model model, @ModelAttribute("clientup") @Valid Client c, BindingResult resultat, @PathVariable Long idPersonne){
		if(resultat.hasErrors()){
			return "PersonneUpdate";
		}
		Client c2 = metier.getClient(idPersonne);
		c2.setNomPersonne(c.getNomPersonne());
		c2.setPrenomPersonne(c.getPrenomPersonne());
		c2.setSexe(c.getSexe());
		c2.setDateNaissance(c.getDateNaissance());
		c2.setAdresse(c.getAdresse());
		c2.setMail(c.getMail());
		c2.setTel(c.getTel());
		metier.updateClient(c2);
		return "redirect:/Personne";
	}

	
	//************************Pour les employes************************
	
	//Ajout d'un employe
		@RequestMapping(value = "/addemploye")
		public String addEmploye(Model model, @ModelAttribute("Employe") @Valid Employe e, BindingResult resultat){
			model.addAttribute("Clients", metier.getListClient());
			model.addAttribute("Employes", metier1.getListEmploye());
			if (resultat.hasErrors()){
				return "Personne";
			}
			metier1.addEmploye(e);
			return "redirect:Personne";
		}
	
}
