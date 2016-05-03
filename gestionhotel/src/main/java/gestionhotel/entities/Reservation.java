package gestionhotel.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/*Auteur: Valérian THOMAS
 * nom: gestionhotel
 *date: 02/05/2016
 *Package:gestionhotel.entities
 *Class:Reservation
 *version:1
 *association: Employé (ManyToOne), Client (ManyToOne), Chambre (ManyToMany)
 * 
 * */


@Entity
public class Reservation implements Serializable {
	
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReservation;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@Column(name="Etat_Reservation")
	private String etatReservation;
	
	
	//association avec Chambre
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="listereservation")
	private List<Chambre> listechambre=new ArrayList<Chambre>();

	
	//getters and setters
	
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getEtatReservation() {
		return etatReservation;
	}
	public void setEtatReservation(String etatReservation) {
		this.etatReservation = etatReservation;
	}

	
	//constructeurs
	
	public Reservation(Date dateDebut, Date dateFin, String etatReservation) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etatReservation = etatReservation;
	}
		
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

}
