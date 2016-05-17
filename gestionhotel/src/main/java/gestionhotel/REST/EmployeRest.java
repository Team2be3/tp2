package gestionhotel.REST;

/*Auteur: Valérian Thomas
 *nom Projet:gestionhotel
 *date:08/05/2016
 *Package:gestionhotel.REST
 *Class:EmployeRest
 *version:1
 * */

import gestionhotel.Metier.InterEmployeMetier;
import gestionhotel.entities.Employe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeRest {
	
	@Autowired
	private InterEmployeMetier metier1;
	
	@RequestMapping(value="/saveEmpl",method=RequestMethod.POST)
	public void addEmploye(@RequestBody Employe e){
		metier1.addEmploye(e);
	}
	
	@RequestMapping(value="/deleteempl/{idPersonne}", method=RequestMethod.DELETE)
	public void deleteEmploye(@PathVariable Long idPersonne){
		metier1.deleteEmploye(idPersonne);
	}
	
	@RequestMapping(value="/updateempl/{idPersonne}", method=RequestMethod.PUT)
	public void updateEmploye(Employe e){
		metier1.updateEmploye(e);
	}
	
	@RequestMapping(value="/getempl/{idPersonne}", method=RequestMethod.GET)
	public Employe getEmploye(@PathVariable Long idPersonne){
		return metier1.getEmploye(idPersonne);
	}
	
	@RequestMapping(value="/getListEmpl", method=RequestMethod.GET)
	public List<Employe> getListEmploye(){
		return metier1.getListEmploye();
	}
	
	@RequestMapping(value="/getListEmpMc/{mc}", method=RequestMethod.GET)
	public List<Employe> getListEmpMc(@PathVariable String mc){
		return metier1.getListEmpMc(mc);		
	}

}
