package fr.humanbooster.liaison.business;

public class Ville {
	private int id;
	private String nom;
	
	public Ville(String nom) {
		this.nom = nom;
	}
	
	// GETTERS & SETTERS
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setId(int i) {
		this.id = i;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// ToString
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + "]";
	}

	
	
	
}
