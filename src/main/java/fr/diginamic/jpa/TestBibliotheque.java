package fr.diginamic.jpa;

import fr.diginamic.jpa.dao.impl.ClientDao;
import fr.diginamic.jpa.dao.impl.EmpruntDao;
import fr.diginamic.jpa.dao.impl.FactoryDao;
import fr.diginamic.jpa.entities.Client;

public class TestBibliotheque {
	public static FactoryDao BIBLIOTHEQUE;
	
	public static void main(String[] args) {
		try {
			TestBibliotheque.BIBLIOTHEQUE = new FactoryDao("bddBibliotheque");
			ClientDao cdo = new ClientDao(TestBibliotheque.BIBLIOTHEQUE);
			EmpruntDao edo = new EmpruntDao(BIBLIOTHEQUE);
			Client c = new Client();
			
			c.setId(1);
			 
			System.out.println(cdo.getOne(c).getEmprunts().size());
			
			// List<Emprunt> emp = cdo.getEmprunts();
			
			// System.out.println(emp.size());
			/*
			 * edo.getAll().forEach(eoi -> { System.out.println(eoi);
			 * 
			 * try {
			 * 
			 * } catch (Exception e) { // TODO: handle exception
			 * System.err.println(e.getMessage()); } });
			 */
			
 		} catch (Exception e) {
			// TODO: handle exception
 			System.err.println(e.getMessage());
		}
	}
}
