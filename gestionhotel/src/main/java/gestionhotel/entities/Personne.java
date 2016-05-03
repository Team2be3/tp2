package gestionhotel.entities;

/*Auteur:Dubuc Jérémy
 *nom Projet:gestionhotel
 *date:02/05/2016
 *Package:gestionhotel.entities
 *Class:Personne
 *version:1.
 *association:
 *fille:client,employe
 * */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance
@DiscriminatorColumn(name="TypePersonne",discriminatorType=DiscriminatorType.STRING)
public class Personne implements Serializable{
	
	/* attributes   */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPersonne;
	@NotEmpty
	private String nomPersonne;
	@NotEmpty
	private String prenomPersonne;
	@NotEmpty
	private String sexe;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotEmpty
	private Date dateNaissance;
	@NotEmpty
	private String adresse;
	@NotEmpty
	private String tel;
	@NotEmpty
	private String mail;
	
	
	/* getEtSet */
	public Long getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}
	public String getNomPersonne() {
		return nomPersonne;
	}
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	public String getPrenomPersonne() {
		return prenomPersonne;
	}
	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	/* constructors */
	public Personne(String nomPersonne, String prenomPersonne, String sexe,
			Date dateNaissance, String adresse, String tel, String mail) {
		super();
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
	}
	
	public Personne() {
		super();
	}
	
	
}
