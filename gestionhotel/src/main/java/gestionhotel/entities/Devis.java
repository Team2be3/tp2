package gestionhotel.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.entities
 *Classe:Devis
 *Version:1
 *Ref-UML:1
 *Sprint:1
 *Ref-UserStory:4
 *Association(s): Produits, Reservation, Facture
 **cc
 * */

@Entity
public class Devis implements Serializable {
	///////////////////
	/////attributs/////
	///////////////////
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idDevis;
	
	
	///////////////////
	/////association///
	///////////////////

	@OneToOne
	@PrimaryKeyJoinColumn
	private Reservation reservation;
	
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="IdDevis")
	private List<Produit> listeProduit = new ArrayList<Produit>();
	
	/* Produit, Reservation, Facture*/
	
	
	/////////////////////////
	/////getters&setters/////
	/////////////////////////
	
	public Long getIdDevis() {
		return idDevis;
	}

	public void setIdDevis(Long idDevis) {
		this.idDevis = idDevis;
	}

	@JsonIgnore
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	@JsonIgnore
	public List<Produit> getListeProduit() {
		return listeProduit;
	}
	@JsonSetter
	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}


	
	///////////////////////
	/////constructeurs/////
	///////////////////////
	
	public Devis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
