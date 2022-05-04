package fr.diginamic.jpa.entities;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "emprunt")
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DATE_DEBUT", nullable = false)
	private Date dateDebut;
	
	@Column(name = "DATE_FIN", nullable = false)
	private Date dateFin;
	
	@Column(name = "DELAI", length = 3, nullable = false)
	private String nom;
	
	// @Column(name = "ID_CLIENT", length = 5, nullable = false)
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client idClient;
	
	@OneToMany(mappedBy = "idEmp")
	private Set<Compo> idCompo;
	
	public Emprunt() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Client getIdClient() {
		return idClient;
	}

	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}
}
