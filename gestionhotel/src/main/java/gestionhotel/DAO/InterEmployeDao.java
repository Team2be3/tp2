package gestionhotel.DAO;

/*Auteur:Dubuc Jérémy
 *nom Projet:gestionhotel
 *date:03/05/2016
 *Package:gestionhotel.DAO
 *Interface: InterEmployeDao
 *Implementation : ImplemEmployeDao
 *version:1.
 * */

import java.util.List;

import gestionhotel.entities.Employe;

public interface InterEmployeDao {
	
	public void addEmploye(Employe e);
	public void deleteEmploye(Long idEmploye);
	public void updateEmploye(Employe e);
	public Employe getEmploye(Long idEmploye);
	public List<Employe> getListEmploye();
	public List<Employe> getListEmpMc(String mc);

}
