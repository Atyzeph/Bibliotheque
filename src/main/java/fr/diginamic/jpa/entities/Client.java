package fr.diginamic.jpa.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "PRENOM", length = 50, nullable = false)
	private String prenom;
	
	@OneToMany(mappedBy = "idClient")
	private Set<Emprunt> emprunts;

	public Client() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
}
