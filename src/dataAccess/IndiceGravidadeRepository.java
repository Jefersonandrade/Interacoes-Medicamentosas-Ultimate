package dataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domainModel.IndiceGravidade;

public class IndiceGravidadeRepository 
{
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public IndiceGravidadeRepository() {
		factory = Persistence.createEntityManagerFactory("InteracoesMedicamentosas"); 
		manager = factory.createEntityManager();
	}
	
	public void Save(IndiceGravidade obj) throws Exception {
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
	
	public void Delete(IndiceGravidade obj) throws Exception {
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
	
	public IndiceGravidade Open(int id) throws Exception {
		try {
			return manager.find(IndiceGravidade.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName() {
		return manager.createQuery("select ig from IndiceGravidade ig order by ig.nome")
		.setMaxResults(10).getResultList();
	}
	
	public List getAllByName() {
		return manager.createQuery("select ig from IndiceGravidade ig order by ig.nome")
		.getResultList();
	}
}

