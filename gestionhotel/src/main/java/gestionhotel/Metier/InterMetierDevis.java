package gestionhotel.Metier;


/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.Metier
 *Classe:InterMetierDevis*/
import gestionhotel.entities.Devis;

import java.util.List;

public interface InterMetierDevis {
	/** addDevis ajoute un devis a la base de donnee**/
	public Devis addDevis(Devis d, Long idReservation);
	
	/**getDevis renvoie un devis grace a son identifiant**/
	public Devis getDevis(Long idDEvis);
	
	/** updateDevis modifie un devis dans la base de donnee**/
	public void updateDevis(Devis d);
	
	/** deleteDevis supprime un devis dans la base de donnee**/
	public void deleteDevis(Long idDevis);
	
	/**  addProduitToDevis ajoute un produit à la liste de devis**/
    public void addProduitToDevis(Long idDevis,Long idProduit);
    
    /** selectDevis selectionne la liste des devis de la base de donnee en fonction de l'id devis**/
    public List<Devis> selectDevis(); 
    
    /** fonction qui calcul le prix du devis ensemble des produits et reservation **/
    public double prixDevis(Long idDevis);
    
}
