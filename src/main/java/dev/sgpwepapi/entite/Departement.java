package dev.sgpwepapi.entite;

public enum Departement {
	INFO("Informatique"), RH("Ressources Humaine");
	
	private String libelle;
	
	Departement(String libelle) {
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return this.libelle;
	}
}
