package fr.diginamic.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.entities.Client;
import fr.diginamic.jpa.entities.Emprunt;

public class ClientDao extends Dao implements Idao<Client>{

	public ClientDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	public boolean add(Client e) throws Exception {
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

	public boolean update(Client e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			Client etrans = em.find(Client.class, e.getId());
			
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

	public boolean delete(Client e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			 em = fd.getEm();
			 em.getTransaction().begin();
			 e = em.find(Client.class, e.getId());
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

	public Client getOne(Client e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			TypedQuery<Client> tpq = em.createQuery("SELECT c FROM Client c WHERE c.id = :id", Client.class);
			tpq.setParameter("id", e.getId());
			return tpq.getResultList().get(0);
		} catch (Exception e2) {
			// TODO: handle exception
			throw new Exception(e2.getMessage());
		} finally {
			fd.close(em);
		}
	}

	public List<Client> getAll() throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			TypedQuery<Client> tpq = em.createQuery("SELECT c FROM Client c", Client.class);
			return tpq.getResultList();
		} catch (Exception e2) {
			// TODO: handle exception
			throw new Exception(e2.getMessage());
		} finally {
			fd.close(em);
		}
	}
	
	public List<Emprunt> getEmprunts(Client e) throws Exception {
		
		EntityManager em = null;
		try {
			em = fd.getEm();
			TypedQuery<Emprunt> tpq = em.createQuery("SELECT e FROM Emprunt e WHERE :client MEMBER OF e.idClient", Emprunt.class);
			tpq.setParameter("id", e.getId());
			return tpq.getResultList();
		} catch (Exception e2) {
			// TODO: handle exception
			throw new Exception(e2.getMessage());
		} finally {
			fd.close(em);
		}

	}

}
