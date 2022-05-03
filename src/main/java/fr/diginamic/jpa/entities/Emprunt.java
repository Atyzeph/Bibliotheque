package fr.diginamic.jpa.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "emprunt")
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DATE_DEBUT", nullable = false)
	private Date dateDebut;
	
	@Column(name = "dateFin", nullable = false)
	private Date dateFin;
	
	@Column(name = "DELAI", length = 3, nullable = false)
	private String nom;
	
	// @Column(name = "ID_CLIENT", length = 5, nullable = false)
	@ManyToOne
	@JoinColumn(name = "client")
	private int idClient;
}
