package gestionhotel.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestionhotel.Metier.InterClientMetier;
import gestionhotel.entities.Client;

/*Auteur: Valérian Thomas
 *nom Projet:gestionhotel
 *date:08/05/2016
 *Package:gestionhotel.REST
 *Class:ClientRest
 *version:1
 * */

@RestController
public class ClientRest {
	
	@Autowired
	private InterClientMetier metier;
	
	@RequestMapping(value="/saveClient",method=RequestMethod.POST)
	public void addClient(@RequestBody Client c){
		metier.addClient(c);
	}
	
	@RequestMapping(value="/deleteclient/{idPersonne}", method=RequestMethod.DELETE)
	public void deleteClient(@PathVariable Long idPersonne){
		metier.deleteClient(idPersonne);
	}
	
	@RequestMapping(value="/updateclient/{idPersonne}", method=RequestMethod.PUT)
	public void updateClient(Client c){
		metier.updateClient(c);
	}
	
	@RequestMapping(value="/getclient/{idPersonne}", method=RequestMethod.GET)
	public Client getClient(@PathVariable Long idPersonne){
		return metier.getClient(idPersonne);
	}
	
	@RequestMapping(value="/getListClient", method=RequestMethod.GET)
	public List<Client> getListClient(){
		return metier.getListClient();
	}
	
	@RequestMapping(value="/getListCliMc/{mc}", method=RequestMethod.GET)
	public List<Client> getListCliMc(@PathVariable String mc){
		return metier.getListCliMc(mc);		
	}

}
