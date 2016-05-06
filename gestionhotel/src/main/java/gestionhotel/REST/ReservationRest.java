package gestionhotel.REST;

/*Auteur:Dubuc Jérémy
 *nom Projet:gestionhotel
 *date:07/05/2016
 *Package:gestionhotel.REST
 *Class:ReservationRest
 *version:1.
 * */

import java.util.List;

import gestionhotel.Metier.InterReservationMetier;
import gestionhotel.entities.Chambre;
import gestionhotel.entities.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReservationRest {
	
	@Autowired
	private InterReservationMetier metierReservation;
	
	@RequestMapping(value="/saveReservation",method=RequestMethod.POST)
	public void addreservation(@RequestBody Reservation r, Long idClient, Long idEmploye) throws Exception{
		metierReservation.addreservation(r, idClient, idEmploye);
	}
	
	@RequestMapping(value="/deletereservation/{idReservation}",method=RequestMethod.DELETE)
	public void deletereservation(@PathVariable Long idReservation){
		metierReservation.deletereservation(idReservation);
	}
	
	@RequestMapping(value="/updatereservation",method=RequestMethod.PUT)
	public void updatereservation(Reservation r){
		metierReservation.updatereservation(r);
	}
	
	@RequestMapping(value="/getreservation/{idReservation}",method=RequestMethod.GET)
	public Reservation getreservation(@PathVariable Long idReservation){
		return metierReservation.getreservation(idReservation);
	}
	
	@RequestMapping(value="/getreservations",method=RequestMethod.GET)
	public List<Reservation> getlistereservations(){
		return metierReservation.getlistereservations();
	}
	
	@RequestMapping(value="/reser/getchambres/{idReservation}",method=RequestMethod.GET)
	public List<Chambre> getlistechares(@PathVariable Long idReservation){
		return metierReservation.getlistechares(idReservation);
	}
	
	@RequestMapping(value="/reser/addchambre/{idReservation}/{idChambre}",method=RequestMethod.PUT)
	public void addChamToReser(@PathVariable Long idReservation,@PathVariable Long idChambre){
		metierReservation.addChamToReser(idReservation, idChambre);
	}
	
	@RequestMapping(value="/reser/deletechambre/{idReservation}/{idChambre}",method=RequestMethod.PUT)
	public void deleteChamToReser(@PathVariable Long idReservation,@PathVariable Long idChambre){
		metierReservation.deleteChamToReser(idReservation, idChambre);
	}
	
}
