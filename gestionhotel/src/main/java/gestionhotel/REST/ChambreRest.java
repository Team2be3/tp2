package gestionhotel.REST;

/*Auteur:Dubuc Jérémy
 *nom Projet:gestionhotel
 *date:07/05/2016
 *Package:gestionhotel.REST
 *Class:ChambreRest
 *version:1.
 * */

import java.util.Date;
import java.util.List;

import gestionhotel.Metier.InterChambreMetier;
import gestionhotel.entities.Chambre;
import gestionhotel.entities.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChambreRest {
	
	@Autowired
	private InterChambreMetier metierChambre;
	
	@RequestMapping(value="/savechambre",method=RequestMethod.POST)
	public void addchambre(@RequestBody Chambre c){
		metierChambre.addchambre(c);
	}
	
	@RequestMapping(value="/deletechambre/{idChambre}",method=RequestMethod.DELETE)
	public void deletechambre(@PathVariable Long idChambre){
		metierChambre.deletechambre(idChambre);
	}
	
	@RequestMapping(value="/updatechambre",method=RequestMethod.PUT)
	public void updatechambre(Chambre c){
		metierChambre.updatechambre(c);
	}
	
	@RequestMapping(value="/getchambre/{idChambre}",method=RequestMethod.GET)
	public Chambre getChambre(@PathVariable Long idChambre){
		return metierChambre.getChambre(idChambre);
	}
	
	@RequestMapping(value="/getchambres",method=RequestMethod.GET)
	public List<Chambre> getlistechambres(){
		return metierChambre.getlistechambres();
	}
	
	@RequestMapping(value="/chambre/getresers/{idChambre}",method=RequestMethod.GET)
	public List<Reservation> getlistereservchambre(@PathVariable Long idChambre){
		return metierChambre.getlistereservchambre(idChambre);
	}
	
	@RequestMapping(value="/chambre/dispo/{datedebut}/{datefin}",method=RequestMethod.GET)
	public List<Chambre> dispochambre(@PathVariable Date datedebut,@PathVariable Date datefin){
		return metierChambre.dispochambre(datedebut, datefin);
	}

}
