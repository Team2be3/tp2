package gestionhotel.Metier;

/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.Metier
 *Classe:InterMetierFacture*/
import gestionhotel.entities.Facture;

import java.util.List;

public interface InterMetierFacture {
	
	/** addFacture ajoute un Facture a la base de donnee**/
	public Facture addFacture (Facture f,Long idDevis);
	
	/** updateFacture modifie un Facture dans la base de donnee**/
	public void updateFacture(Facture f);
	
	/** deleteFacture supprime un Facture dans la base de donnee**/
	public void deleteFacturet(Long idFacture);
	
	/**getFacture renvoie un Facture grace a son identifiant**/
	public Facture getFacture(Long idFacture);
	
	/** selectFacture selectionne la liste deFacture de la base de donnee  **/
	public List<Facture> selectFacture();
	
}
