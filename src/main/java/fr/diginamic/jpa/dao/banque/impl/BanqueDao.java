package fr.diginamic.jpa.dao.banque.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.entities.Banque;
import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.dao.impl.Dao;
import fr.diginamic.jpa.dao.impl.FactoryDao;

public class BanqueDao extends Dao implements Idao<Banque>{

	public BanqueDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	public boolean add(Banque e) throws Exception {
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

	public boolean update(Banque e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			Banque etrans = em.find(Banque.class, e.getIdBanque());
			
			if (etrans != null) {
				etrans.setNom(e.getNom());
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

	public boolean delete(Banque e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			 em = fd.getEm();
			 em.getTransaction().begin();
			 e = em.find(Banque.class, e.getIdBanque());
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

	public Banque getOne(Banque e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			TypedQuery<Banque> tpq = em.createQuery("SELECT c FROM Banque c WHERE c.id = :id", Banque.class);
			tpq.setParameter("id", e.getIdBanque());
			return tpq.getResultList().get(0);
		} catch (Exception e2) {
			// TODO: handle exception
			throw new Exception(e2.getMessage());
		} finally {
			fd.close(em);
		}
	}

	public List<Banque> getAll() throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			TypedQuery<Banque> tpq = em.createQuery("SELECT c FROM Banque c", Banque.class);
			return tpq.getResultList();
		} catch (Exception e2) {
			// TODO: handle exception
			throw new Exception(e2.getMessage());
		} finally {
			fd.close(em);
		}
	}
}
