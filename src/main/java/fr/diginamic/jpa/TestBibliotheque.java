package fr.diginamic.jpa;

import java.util.Iterator;

import fr.diginamic.jpa.dao.impl.ClientDao;
import fr.diginamic.jpa.dao.impl.EmpruntDao;
import fr.diginamic.jpa.dao.impl.FactoryDao;
import fr.diginamic.jpa.entities.Client;
import fr.diginamic.jpa.entities.Compo;

public class TestBibliotheque {
	public static FactoryDao BIBLIOTHEQUE;
	
	public static void main(String[] args) {
		try {
			TestBibliotheque.BIBLIOTHEQUE = new FactoryDao("bddBibliotheque");
			ClientDao cdo = new ClientDao(TestBibliotheque.BIBLIOTHEQUE);
			EmpruntDao edo = new EmpruntDao(BIBLIOTHEQUE);
			Client c = new Client();
			
			// id client
			c.setId(2);
			 
			// Extraction des emprunts
			cdo.getOne(c).getEmprunts().forEach(e -> {
				System.out.println(e.getId());
				Iterator<Compo> ic = e.getIdCompo().iterator();
				while (ic.hasNext()) {
					Compo co = ic.next();
					
					if (co != null) {
					System.out.println(co.getIdLivre().getTitre());
					}
				}
			});
			
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
