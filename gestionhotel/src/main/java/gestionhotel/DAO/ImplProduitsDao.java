package gestionhotel.DAO;

/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.DAO
 *Classe:ImplProduitDao
 *Version:1
 *Ref-UML:1
 *Sprint:1
 *Ref-UserStory:4
 * */

import gestionhotel.entities.Client;
import gestionhotel.entities.Produit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ImplProduitsDao implements InterfProduitDao {
	@PersistenceContext
    private EntityManager em;

	@Override
	public Produit addProduit(Produit p) {
		em.persist(p);
		return null;
	}

	@Override
	public void updateProduit(Produit p) {
		em.merge(p);
		
	}

	@Override
	public void deleteProduit(Long idProduit) {
		Produit p=em.find(Produit.class, idProduit);
		em.remove(p);
	}

	@Override
	public Produit getProduit(Long idProduit) {
		Produit p=em.find(Produit.class, idProduit);
		return p;
	}

	@Override
	public List<Produit> selectProduit() {
		Query req= (Query) em.createQuery("from Produit");
		return req.getResultList();
	}

	@Override
	public List<Produit> selectProduitParMc(String mc) {

		Query req= (Query) em.createQuery("from Produit p where p.nomProduit = :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

}
