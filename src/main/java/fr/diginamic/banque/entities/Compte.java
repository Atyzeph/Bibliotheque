package fr.diginamic.banque.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCompte;
	
	@Column(name = "numero", length = 50, nullable = false)
	private String numero;
	
	@Column(name = "solde", length = 50, nullable = false)
	private double solde;
	
	@OneToMany(mappedBy = "compte")
	private Set<Clients> clientss;

	@OneToOne
	private Operation operation;
	
	
	public Compte() {
	}
	
	
	// Avec contraintes
	public Compte(int idCompte, String numero, double solde, Set<Clients> clientss, Operation operation) {
		super();
		this.idCompte = idCompte;
		this.numero = numero;
		this.solde = solde;
		this.clientss = clientss;
		this.operation = operation;
	}


	// Sans contraintes
	public Compte(String numero, double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Clients> getClientss() {
		return clientss;
	}

	public void setClientss(Set<Clients> clientss) {
		this.clientss = clientss;
	}


	public Operation getOperation() {
		return operation;
	}


	public void setOperation(Operation operation) {
		this.operation = operation;
	}
}
