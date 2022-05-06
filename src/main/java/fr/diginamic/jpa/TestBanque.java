package fr.diginamic.jpa;

import java.time.LocalDate;
import fr.diginamic.banque.entities.*;
import fr.diginamic.jpa.dao.banque.impl.*;
import fr.diginamic.jpa.dao.impl.FactoryDao;

public class TestBanque {

	public static FactoryDao BANQUE;
	
	public static void main(String[] args) {
		try {
			
			TestBanque.BANQUE = new FactoryDao("bddBanquem02");
			LocalDate date = LocalDate.now();
			ClientsDao cdao = new ClientsDao(TestBanque.BANQUE);
			BanqueDao bqdao = new BanqueDao(TestBanque.BANQUE);
			CompteDao cptdao = new CompteDao(TestBanque.BANQUE);
			OperationDao opdao = new OperationDao(TestBanque.BANQUE);
			
			Adresse adr = new Adresse(8, "Rue de la Paix", 75000, "Paris");
			Clients c = new Clients("Martin", "Alice", date, adr);
			
			Banque bq = new Banque("Crédit Mutuel");
			Compte cpt = new Compte("4895 5050 7852 6574", 2000);
			Operation op = new Operation(date, 2000, "Offre de bienvenue");
			
			cdao.add(c);
			bqdao.add(bq);
			cptdao.add(cpt);
			opdao.add(op);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
}
