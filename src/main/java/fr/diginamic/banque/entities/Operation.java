package fr.diginamic.banque.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "operation")
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOperation;
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Column(name = "montant", nullable = false)
	private double montant;
	
	@Column(name = "motif", length = 255, nullable = false)
	private String motif;
	
	@OneToMany(mappedBy = "Operation")
	private Set<Compte> comptes;

	public Operation() {
	}
	
	
	// Avec contraintes
	public Operation(int idOperation, LocalDate date, double montant, String motif, Set<Compte> comptes) {
		super();
		this.idOperation = idOperation;
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.comptes = comptes;
	}


	// Sans contraintes
	public Operation(LocalDate date, double montant, String motif) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
	}

	public int getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(int id) {
		this.idOperation = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
}
