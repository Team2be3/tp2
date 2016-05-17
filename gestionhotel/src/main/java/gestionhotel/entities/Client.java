package gestionhotel.entities;

/*Auteur:Dubuc Jérémy
 *nom Projet:gestionhotel
 *date:03/05/2016
 *Package:gestionhotel.entities
 *Class:Client
 *version:1.
 *association:List<Reservation>
 *mere:personne
 **cc
 * */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
@DiscriminatorValue("Client")
public class Client extends Personne implements Serializable{
	
	/* association */
	@OneToMany(mappedBy="client")
	private List<Reservation> reservations= new ArrayList<Reservation>();

	
	/* getEtSet */
	@JsonIgnore
	public List<Reservation> getReservations() {
		return reservations;
	}
	@JsonSetter
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	/* constructors */
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nomPersonne, String prenomPersonne, String sexe,
			Date dateNaissance, String adresse, String tel, String mail) {
		super(nomPersonne, prenomPersonne, sexe, dateNaissance, adresse, tel, mail);
		// TODO Auto-generated constructor stub
	}

}
