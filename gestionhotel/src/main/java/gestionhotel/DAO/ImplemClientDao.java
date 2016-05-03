package gestionhotel.DAO;

/*Auteur:Dubuc Jérémy
 *nom Projet:gestionhotel
 *date:03/05/2016
 *Package:gestionhotel.DAO
 *Implementation : ImplemClientDao
 *Interface: InterClientDao
 *version:1.
 * */

import gestionhotel.entities.Client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ImplemClientDao implements InterClientDao {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public void addClient(Client c) {
		em.persist(c);
	}

	@Override
	public void deleteClient(Long idClient) {
		Client c=em.find(Client.class, idClient);
		em.remove(c);
	}

	@Override
	public void updateClient(Client c) {
		em.merge(c);
	}

	@Override
	public Client getClient(Long idClient) {
		Client c=em.find(Client.class, idClient);
		return c;
	}

	@Override
	public List<Client> getListClient() {
		Query req= (Query) em.createQuery("from Client");
		return req.getResultList();
	}

	@Override
	public List<Client> getListCliMc(String mc) {
		Query req= (Query) em.createQuery("from Client c where c.nomPersonne = :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

}
