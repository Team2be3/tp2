package gestionhotel.DAO;

/*Auteur:Dubuc Jérémy
 *nom Projet:gestionhotel
 *date:03/05/2016
 *Package:gestionhotel.DAO
 *Implementation : ImplemEmployeDao
 *Interface: InterEmployeDao
 *version:1.
 * */

import gestionhotel.entities.Employe;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ImplemEmployeDao implements InterEmployeDao {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public void addEmploye(Employe e) {
		em.persist(e);
		
	}

	@Override
	public void deleteEmploye(Long idEmploye) {
		Employe e=em.find(Employe.class, idEmploye);
		em.remove(e);
		
	}

	@Override
	public void updateEmploye(Employe e) {
		em.merge(e);
		
	}

	@Override
	public Employe getEmploye(Long idEmploye) {
		Employe e=em.find(Employe.class, idEmploye);
		return e;
	}

	@Override
	public List<Employe> getListEmploye() {
		Query req= (Query) em.createQuery("from Employe");
		return req.getResultList();
	}

	@Override
	public List<Employe> getListEmpMc(String mc) {
		Query req= (Query) em.createQuery("from Employe e where e.nomPersonne = :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

}
