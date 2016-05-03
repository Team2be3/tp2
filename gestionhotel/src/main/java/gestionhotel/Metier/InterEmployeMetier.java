package gestionhotel.Metier;

import gestionhotel.entities.Employe;

import java.util.List;


public interface InterEmployeMetier {

	public void addEmploye(Employe e);
	public void deleteEmploye(Long idEmploye);
	public void updateEmploye(Employe e);
	public Employe getEmploye(Long idEmploye);
	public List<Employe> getListEmploye();
	public List<Employe> getListEmpMc(String mc);
}
