package fr.diginamic.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.entities.Client;

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
		return false;
	}

	public Client getOne(Client e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Client> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
