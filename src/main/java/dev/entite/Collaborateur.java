package dev.entite;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Collaborateur {

	@Id
	private String matricule;
	private String nom;
	@ManyToOne
	private Departement departement;
	@ManyToOne
	private Banque banque;

	public Collaborateur() {
		super();
	}

	public Collaborateur(String matricule, Departement departement, Banque banque) {
		super();
		this.matricule = matricule;
		this.departement = departement;
		this.banque = banque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

}
