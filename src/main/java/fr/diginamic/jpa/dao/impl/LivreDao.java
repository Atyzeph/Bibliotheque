package fr.diginamic.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.entities.Livre;

public class LivreDao extends Dao implements Idao<Livre>{

	public LivreDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	public boolean add(Livre e) throws Exception {
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

	public boolean update(Livre e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			Livre etrans = em.find(Livre.class, e.getId());
			
			if (etrans != null) {
				etrans.setAuteur(e.getAuteur());
				etrans.setTitre(e.getTitre());
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

	public boolean delete(Livre e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			 em = fd.getEm();
			 em.getTransaction().begin();
			 e = em.find(Livre.class, e.getId());
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

	public Livre getOne(Livre e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Livre> getAll() throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<Livre> tqb = fd.getEm().createQuery("select liv from Livre liv", Livre.class);
		return tqb.getResultList();
	}
}
