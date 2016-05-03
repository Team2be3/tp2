package gestionhotel.DAO;

import java.util.List;

import gestionhotel.entities.Devis;
import gestionhotel.entities.Produit;

public interface InterfDevisDao {

    
	/** addDevis ajoute un devis a la base de donnee**/
	public Devis addDevis(Devis d, Long idReservation);
	
	/**getDevis renvoie un devis grace a son identifiant**/
	public Devis getDevis(Long idDEvis);
	
	/** updateDevis modifie un devis dans la base de donnee**/
	public void updateDevis(Devis d);
	
	/** deleteDevis supprime un devis dans la base de donnee**/
	public void deleteDevis(Long idDevis);
	
	/**  addProduitToDevis ajoute un produit � la liste de devis**/
    public void addProduitToDevis(Long idDevis,Long idProduit);
    
    /** selectDevis selectionne la liste des devis de la base de donnee en fonction de l'id devis**/
    public List<Devis> selectDevis(); 
    
    
       
}
