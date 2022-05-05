package fr.diginamic.jpa.dao.banque.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.entities.Compte;
import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.dao.impl.Dao;
import fr.diginamic.jpa.dao.impl.FactoryDao;

public class CompteDao extends Dao implements Idao<Compte>{

	public CompteDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	public boolean add(Compte e) throws Exception {
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

	public boolean update(Compte e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			Compte etrans = em.find(Compte.class, e.getIdCompte());
			
			if (etrans != null) {
				etrans.setNumero(e.getNumero());
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

	public boolean delete(Compte e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			 em = fd.getEm();
			 em.getTransaction().begin();
			 e = em.find(Compte.class, e.getIdCompte());
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

	public Compte getOne(Compte e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			TypedQuery<Compte> tpq = em.createQuery("SELECT c FROM Compte c WHERE c.id = :id", Compte.class);
			tpq.setParameter("id", e.getIdCompte());
			return tpq.getResultList().get(0);
		} catch (Exception e2) {
			// TODO: handle exception
			throw new Exception(e2.getMessage());
		} finally {
			fd.close(em);
		}
	}

	public List<Compte> getAll() throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			TypedQuery<Compte> tpq = em.createQuery("SELECT c FROM Compte c", Compte.class);
			return tpq.getResultList();
		} catch (Exception e2) {
			// TODO: handle exception
			throw new Exception(e2.getMessage());
		} finally {
			fd.close(em);
		}
	}
}
