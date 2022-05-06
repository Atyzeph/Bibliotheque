package fr.diginamic.banque.entities;

import javax.persistence.*;

@Embeddable
public class Adresse {

	private int numero;
	private String rue;
	private int codePostale;
	private String ville;
	
	public Adresse() {
	}

	public Adresse(int numero, String rue, int codePostale, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
}
