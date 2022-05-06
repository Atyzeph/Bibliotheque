package fr.diginamic.jpa;

import java.time.LocalDate;
import fr.diginamic.banque.entities.Adresse;
import fr.diginamic.banque.entities.Banque;
import fr.diginamic.banque.entities.Clients;
import fr.diginamic.banque.entities.Compte;
import fr.diginamic.banque.entities.Operation;
import fr.diginamic.jpa.dao.impl.ClientDao;
import fr.diginamic.jpa.dao.impl.FactoryDao;

public class TestBanque {

	public static FactoryDao BANQUE;
	
	public static void main(String[] args) {
		try {
			TestBanque.BANQUE = new FactoryDao("bddBanquem02");
			LocalDate date = LocalDate.now();
			ClientDao cdo = new ClientDao(TestBibliotheque.BIBLIOTHEQUE);
			
			Banque bq = new Banque("Crédit mutuel");
			Compte cpt = new Compte("4895 5050 7852 6574", 2000);
			Operation op = new Operation(date, 2000, "Offre de bienvenue");
			Adresse adr = new Adresse(8, "Rue de la Paix", 75000, "Paris");
			Clients c = new Clients("Martin", "Alice", date, adr);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
}
