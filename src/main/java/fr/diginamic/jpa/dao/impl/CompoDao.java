package fr.diginamic.jpa.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.entities.Compo;

public class CompoDao extends Dao implements Idao<Compo>{

	public CompoDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Compo e) throws Exception {
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

	@Override
	public boolean update(Compo e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			Compo etrans = em.find(Compo.class, e.getId());
			
			if (etrans != null) {
				etrans.setIdEmp(e.getIdEmp());
				etrans.setIdLivre(e.getIdLivre());
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

	@Override
	public boolean delete(Compo e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			 em = fd.getEm();
			 em.getTransaction().begin();
			 e = em.find(Compo.class, e.getId());
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

	@Override
	public Compo getOne(Compo e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
