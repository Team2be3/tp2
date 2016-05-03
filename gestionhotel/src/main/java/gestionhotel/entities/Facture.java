package gestionhotel.entities;

import java.io.Serializable;
import java.util.Date;

import javax.jws.Oneway;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/*Auteur(s):Shéhérazade
 *Nom projet:GestionHotel
 *Date:02/05/2016
 *Package:gestionhotel.entities
 *Classe:Facture
 *Version:1
 *Ref-UML:1
 *Sprint:1
 *Ref-UserStory:4
 *Association(s): Devis
 * */

@Entity
public class Facture implements Serializable{

	///////////////////
	/////attributs/////
	///////////////////
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idFacture;
	@Temporal(TemporalType.DATE)
	private Date datePaiement;
	
	
	@Transient
	private String typePaiement;
	

///////////////////
/////association///
///////////////////
	@OneToOne
	@PrimaryKeyJoinColumn
	private Devis devis;

/////////////////////////
/////getters&setters/////
/////////////////////////
	
	
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public Date getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}
	public String getTypePaiement() {
		return typePaiement;
	}
	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}
	

public Devis getDevis() {
		return devis;
	}
	public void setDevis(Devis devis) {
		this.devis = devis;
	}
///////////////////////
/////constructeurs/////
///////////////////////
public Facture(Date datePaiement, String typePaiement) {
	super();
	this.datePaiement = datePaiement;
	this.typePaiement = typePaiement;
}
public Facture() {
	super();
	// TODO Auto-generated constructor stub
}

}	
