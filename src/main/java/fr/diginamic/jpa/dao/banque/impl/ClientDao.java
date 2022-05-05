package fr.diginamic.jpa.dao.banque.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.dao.impl.Dao;
import fr.diginamic.jpa.dao.impl.FactoryDao;
import fr.diginamic.banque.entities.Clients;

public class ClientDao extends Dao implements Idao<Clients>{

	public ClientDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	public boolean add(Clients e) throws Exception {
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

	public boolean update(Clients e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			Clients etrans = em.find(Clients.class, e.getId());
			
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

	public boolean delete(Clients e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			 em = fd.getEm();
			 em.getTransaction().begin();
			 e = em.find(Clients.class, e.getId());
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

	public Clients getOne(Clients e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			TypedQuery<Clients> tpq = em.createQuery("SELECT c FROM Clients c WHERE c.id = :id", Clients.class);
			tpq.setParameter("id", e.getId());
			return tpq.getResultList().get(0);
		} catch (Exception e2) {
			// TODO: handle exception
			throw new Exception(e2.getMessage());
		} finally {
			fd.close(em);
		}
	}

	public List<Clients> getAll() throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			TypedQuery<Clients> tpq = em.createQuery("SELECT c FROM Clients c", Clients.class);
			return tpq.getResultList();
		} catch (Exception e2) {
			// TODO: handle exception
			throw new Exception(e2.getMessage());
		} finally {
			fd.close(em);
		}
	}
}
