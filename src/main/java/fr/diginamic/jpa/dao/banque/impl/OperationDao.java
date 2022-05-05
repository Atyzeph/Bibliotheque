package fr.diginamic.jpa.dao.banque.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.entities.Operation;
import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.dao.impl.Dao;
import fr.diginamic.jpa.dao.impl.FactoryDao;

public class OperationDao extends Dao implements Idao<Operation>{

	public OperationDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	public boolean add(Operation e) throws Exception {
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

	public boolean update(Operation e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			Operation etrans = em.find(Operation.class, e.getIdOperation());
			
			if (etrans != null) {
				etrans.setMontant(e.getMontant());
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

	public boolean delete(Operation e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			 em = fd.getEm();
			 em.getTransaction().begin();
			 e = em.find(Operation.class, e.getIdOperation());
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

	public Operation getOne(Operation e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			TypedQuery<Operation> tpq = em.createQuery("SELECT c FROM Operation c WHERE c.id = :id", Operation.class);
			tpq.setParameter("id", e.getIdOperation());
			return tpq.getResultList().get(0);
		} catch (Exception e2) {
			// TODO: handle exception
			throw new Exception(e2.getMessage());
		} finally {
			fd.close(em);
		}
	}

	public List<Operation> getAll() throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			TypedQuery<Operation> tpq = em.createQuery("SELECT c FROM Operation c", Operation.class);
			return tpq.getResultList();
		} catch (Exception e2) {
			// TODO: handle exception
			throw new Exception(e2.getMessage());
		} finally {
			fd.close(em);
		}
	}
}
