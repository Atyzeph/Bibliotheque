package fr.diginamic.banque.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Clients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nom", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "prenom", length = 50, nullable = false)
	private String prenom;
	
	@Column(name = "dateNaissance", nullable = false)
	private LocalDate dateNaissance;
	
	@OneToMany(mappedBy = "clients")
	private Set<Banque> banques;
	
	@OneToMany(mappedBy = "clients")
	private Set<Compte> comptes;
	
	
	@Embedded
	private Adresse adresse;

	public Clients() {
	}	
	
	// Avec contraintes
	public Clients(String nom, String prenom, LocalDate dateNaissance, Banque banque, Compte compte, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.banques.add(banque);
		this.comptes.add(compte);
		this.adresse = adresse;
	}

	// Sans contraintes
	public Clients(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
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

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Banque> getBanques() {
		return banques;
	}

	public void setBanques(Set<Banque> banques) {
		this.banques = banques;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
}
