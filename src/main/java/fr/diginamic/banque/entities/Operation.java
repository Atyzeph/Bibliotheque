package fr.diginamic.banque.entities;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "operation")
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Column(name = "montant", nullable = false)
	private double montant;
	
	@Column(name = "motif", length = 255, nullable = false)
	private String motif;

	public Operation() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
