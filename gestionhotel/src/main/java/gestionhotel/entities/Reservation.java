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

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


/*Auteur: Val�rian THOMAS
 * nom: gestionhotel
 *date: 02/05/2016
 *Package:gestionhotel.entities
 *Class:Reservation
 *version:1
 *association: Employ� (ManyToOne), Client (ManyToOne), Chambre (ManyToMany)
 * hi
 * */


@Entity
public class Reservation implements Serializable {
	
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReservation;
	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateFin;
	@Column(name="Etat_Reservation")
	@NotEmpty
	private String etatReservation;
	
	
	//association 
	@ManyToMany(/*fetch=FetchType.LAZY,*/ mappedBy="listereservation")
	private List<Chambre> listechambre=new ArrayList<Chambre>();
	
	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name="id_client")
	private Client client;
	
	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name="id_employe")
	private Employe employe;
	
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

	
	public List<Chambre> getListechambre() {
		return listechambre;
	}
	public void setListechambre(List<Chambre> listechambre) {
		this.listechambre = listechambre;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
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
