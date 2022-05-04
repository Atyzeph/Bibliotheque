package fr.diginamic.jpa;

import fr.diginamic.jpa.dao.impl.ClientDao;
import fr.diginamic.jpa.dao.impl.EmpruntDao;
import fr.diginamic.jpa.dao.impl.FactoryDao;

public class TestBibliotheque {
	public static FactoryDao BIBLIOTHEQUE;
	
	public static void main(String[] args) {
		try {
			TestBibliotheque.BIBLIOTHEQUE = new FactoryDao("bddBibliotheque");
			ClientDao cdo = new ClientDao(new FactoryDao("bddBibliotheque"));
			EmpruntDao edo = new EmpruntDao(new FactoryDao("bddBibliotheque"));
			
			edo.getAll().forEach(eoi -> {
				System.out.println(eoi);
				
				try {
					
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(e.getMessage());
				}
			});
			
 		} catch (Exception e) {
			// TODO: handle exception
 			System.err.println(e.getMessage());
		}
	}
}
