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

	public Banque() {
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
}
