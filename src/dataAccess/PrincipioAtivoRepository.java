package dataAccess;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domainModel.PrincipioAtivo;

public class PrincipioAtivoRepository 
{
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public PrincipioAtivoRepository() {
		factory = Persistence.createEntityManagerFactory("InteracoesMedicamentosas"); 
		manager = factory.createEntityManager();
	}
	
	public void Save(PrincipioAtivo obj) throws Exception {
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(obj);
			transaction.commit();
		}
		catch(Exception ex){
			transaction.rollback();
			throw ex;
		}
	}
	
	public void Delete(PrincipioAtivo obj) throws Exception {
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(obj);
			transaction.commit();
		}
		catch(Exception ex){
			transaction.rollback();
			throw ex;
		}
	}
	
	public PrincipioAtivo Open(int id) throws Exception {
		try {
			return manager.find(PrincipioAtivo.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName() {
		return manager.createQuery("select pa from PrincipioAtivo pa order by pa.nome")
		.setMaxResults(10).getResultList();
	}
	
	public List getAllByName() {
		return manager.createQuery("select pa from PrincipioAtivo pa order by pa.nome")
		.getResultList();
	}
}
