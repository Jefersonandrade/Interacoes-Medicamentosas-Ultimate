package dataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domainModel.IndiceRisco;

public class IndiceRiscoRepository 
{
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public IndiceRiscoRepository() {
		factory = Persistence.createEntityManagerFactory("InteracoesMedicamentosas"); 
		manager = factory.createEntityManager();
	}
	
	public void Save(IndiceRisco obj) throws Exception {
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
	
	public void Delete(IndiceRisco obj) throws Exception {
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
	
	public IndiceRisco Open(int id) throws Exception {
		try {
			return manager.find(IndiceRisco.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName() {
		return manager.createQuery("select ir from IndiceRisco ir order by ir.nome")
		.setMaxResults(10).getResultList();
	}
	
	public List getAllByName() {
		return manager.createQuery("select ir from IndiceRisco ir order by ir.nome")
		.getResultList();
	}
}

