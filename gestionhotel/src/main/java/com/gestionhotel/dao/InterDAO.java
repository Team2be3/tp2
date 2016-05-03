package com.gestionhotel.dao;

import gestionhotel.entities.Devis;
import gestionhotel.entities.Produit;

import java.util.List;
/**
 * @author Shéhérazade Taouza
 * nomProjet : GestionHotel
 * Interface  DAO
 * date 03/05/2016
 * Package : com.gestionhotel.dao
 * ref-Uml:1
 * version 1
 * Sprint : 1
 * association: avec ImplMetier
 * 
 */

public interface InterDAO {
	
	/** addProduit ajoute un produit a la base de donnee**/
	public Produit addProduit(Produit p);
	
	/** updateProduit modifie un produit dans la base de donnee**/
	public void updateProduit(Produit p);
	
	/** deleteProduit supprime un produit dans la base de donnee**/
	public void deleteProduit(Long idProduit);
	
	/**getProduit renvoie un Produit grace a son identifiant**/
	public Produit getProduit(Long idProduit);
	
	/** selectProduit selectionne la liste deproduit de la base de donnee  **/
	public List<Produit> selectProduit();
	
	/** selectProduit selectionne une liste deproduit de la base de donnee par mots cles**/
	public List<Produit> selectProduitParMc(String mc);
	
	/** selectProduit selectionne une liste deproduit de la base de donnee en fonction de l'id devis**/
    public void addProduitToDevis(Long idDevis,Long idProduit);
    
    
	/** addDevis ajoute un devis a la base de donnee**/
	public Devis addDevis(Devis d);
	
	/** updateDevis modifie un devis dans la base de donnee**/
	public void updateDevis(Devis d);
	
	/** deleteDevis supprime un devis dans la base de donnee**/
	public void deleteDevis(Long idDevis);
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
