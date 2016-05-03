package gestionhotel.DAO;

import gestionhotel.entities.Produit;

import java.util.List;

public interface InterfProduitDao {
	
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
	


}
