package gestionhotel.entities;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.entities
 *Classe:Produit
 *Version:1
 *Ref-UML:1
 *Sprint:1
 *Ref-UserStory:4
 *Association(s): Devis
 * */

@Entity
public class Produit implements Serializable {
	///////////////////
	/////attributs/////
	///////////////////
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	private String nomProduit;
	private double prixProduit;
	private String descriptionProduit;
	
	/////////////////////////
	/////getters&setters/////
	/////////////////////////
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public double getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(double prixProduit) {
		this.prixProduit = prixProduit;
		
	}	
	public String getDescriptionProduit() {
		return descriptionProduit;
	}
	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}
		///////////////////////
		/////constructeurs/////
		///////////////////////
		
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String nomProduit, double prixProduit,
			String descriptionProduit) {
		super();
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.descriptionProduit = descriptionProduit;
	}

	


	
	
	
	
	

}
