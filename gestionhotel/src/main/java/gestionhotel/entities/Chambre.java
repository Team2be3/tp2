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

/*Auteur: Val�rian THOMAS
 * nom: gestionhotel
 *date: 02/05/2016
 *Package:gestionhotel.entities
 *Class:Reservation
 *version:1
 *association: Reservation (ManyToMany)
 * 
 * */

@Entity

public class Chambre implements Serializable{
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idChambre;
	@Column
	private Integer capacite;
	@Column
	private Double prix;
	@Column
	private String description;
	
	//association avec Reservation
	
	@ManyToMany (fetch=FetchType.LAZY)
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
	
	//constructeurs
	
	public Chambre(Integer capacite, Double prix, String description) {
		super();
		this.capacite = capacite;
		this.prix = prix;
		this.description = description;
	}
	
	public Chambre() {
		// TODO Auto-generated constructor stub
	}
	
}
