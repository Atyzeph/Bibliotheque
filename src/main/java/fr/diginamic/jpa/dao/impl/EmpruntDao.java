package fr.diginamic.jpa.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.entities.Emprunt;

public class EmpruntDao extends Dao implements Idao<Emprunt>{

	public EmpruntDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	public boolean add(Emprunt e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			
			return true;
		} catch (Exception ex) {
			// TODO: handle exception
			System.err.println(ex.getMessage());
		}
		return false;
	}

	public boolean update(Emprunt e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			Emprunt etrans = em.find(Emprunt.class, e.getId());
			
			if (etrans != null) {
				etrans.setDateDebut(e.getDateDebut());
				etrans.setDateFin(e.getDateFin());
				etrans.setNom(e.getNom());
				etrans.setIdClient(e.getIdClient());
				em.merge(etrans);
				em.getTransaction().commit();
				
				return true;
			}			
			return true;
		} catch (Exception ex) {
			// TODO: handle exception
			System.err.println(ex.getMessage());
		}
		return false;
	}

	public boolean delete(Emprunt e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			 em = fd.getEm();
			 em.getTransaction().begin();
			 e = em.find(Emprunt.class, e.getId());
			 if(e != null) {
					 em.remove(e);
					 em.getTransaction().commit();
					 return true;
			 }
			 return false;
			
		}
		catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
		finally {
			fd.close(em);
		}
	}

	public Emprunt getOne(Emprunt e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Emprunt> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
