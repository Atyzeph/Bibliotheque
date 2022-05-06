package fr.diginamic.banque.entities;

import javax.persistence.*;

@Entity
@Table(name = "banque")
public class Banque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBanque;
	
	@Column(name = "nom", length = 50, nullable = false )
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "id") // id client dans la bdd
	private Clients clients;

	public Banque() {
	}
	
	
	// Avec contraintes
	public Banque(int idBanque, String nom, Clients clients) {
		super();
		this.idBanque = idBanque;
		this.nom = nom;
		this.clients = clients;
	}


	// Sans contraintes
	public Banque(String nom) {
		super();
		this.nom = nom;
	}

	public int getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(int idBanque) {
		this.idBanque = idBanque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}
}
