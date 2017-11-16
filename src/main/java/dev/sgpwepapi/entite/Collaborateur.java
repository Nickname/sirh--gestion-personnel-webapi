package dev.sgpwepapi.entite;

import javax.persistence.*;

@Entity
@Table(name="COLLABORATEUR")
public class Collaborateur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="matricule")
	private String matricule;
	
	@Column(name="departement")
	private Departement departement;
	
	@OneToOne
	private CompteBancaire compte;
	
	public Collaborateur() {	}

	public Collaborateur(String nom, String prenom, String matricule, Departement departement, CompteBancaire compte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.departement = departement;
		this.compte = compte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public CompteBancaire getCompte() {
		return compte;
	}

	public void setCompte(CompteBancaire compte) {
		this.compte = compte;
	}
	
}
