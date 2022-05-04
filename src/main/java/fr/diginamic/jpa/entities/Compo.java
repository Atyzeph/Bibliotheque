package fr.diginamic.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "compo")
public class Compo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ID_LIV")
	private Livre idLivre;
	
	@ManyToOne
	@JoinColumn(name = "ID_EMP")
	private Emprunt idEmp;
	
	
	public Compo() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Livre getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Livre idLivre) {
		this.idLivre = idLivre;
	}

	public Emprunt getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(Emprunt idEmp) {
		this.idEmp = idEmp;
	}
	
	
}
