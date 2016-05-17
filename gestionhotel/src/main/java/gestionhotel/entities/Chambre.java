package gestionhotel.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

/*Auteur: Valérian THOMAS
 * nom: gestionhotel
 *date: 02/05/2016
 *Package:gestionhotel.entities
 *Class:Reservation
 *version:1
 *association: Reservation (ManyToMany)
 * cc
 * */

@Entity

public class Chambre implements Serializable{
	
	//attributs
	@Id
	private Long idChambre;
	@Column
	@NotNull
	private Integer capacite;
	@Column
	@NotNull
	private Double prix;
	@Column
	@NotEmpty
	private String description;
	
	//association avec Reservation
	
	@ManyToMany //(fetch=FetchType.LAZY)
	@JoinTable(name="Chambre_res")
	private List<Reservation> listereservation = new ArrayList<Reservation>();

	//getters et setters
	
	public Long getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(Long idChambre) {
		this.idChambre = idChambre;
	}
	public Integer getCapacite() {
		return capacite;
	}
	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonIgnore
	public List<Reservation> getListereservation() {
		return listereservation;
	}
	@JsonSetter
	public void setListereservation(List<Reservation> listereservation) {
		this.listereservation = listereservation;
	}
	
	//constructeurs
	

	public Chambre(Long idChambre,Integer capacite, Double prix, String description) {
		super();
		this.idChambre= idChambre;
		this.capacite = capacite;
		this.prix = prix;
		this.description = description;
	}
	
	public Chambre() {
		// TODO Auto-generated constructor stub
	}
	
}
