package dataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domainModel.IndiceConfiabilidade;

public class IndiceConfiabilidadeRepository 
{
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public IndiceConfiabilidadeRepository() {
		factory = Persistence.createEntityManagerFactory("InteracoesMedicamentosas"); 
		manager = factory.createEntityManager();
	}
	
	public void Save(IndiceConfiabilidade obj) throws Exception {
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
	
	public void Delete(IndiceConfiabilidade obj) throws Exception {
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
	
	public IndiceConfiabilidade Open(int id) throws Exception {
		try {
			return manager.find(IndiceConfiabilidade.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName() {
		return manager.createQuery("select ic from IndiceConfiabilidade ic order by ic.nome")
		.setMaxResults(10).getResultList();
	}
	
	public List getAllByName() {
		return manager.createQuery("select ic from IndiceConfiabilidade ic order by ic.nome")
		.getResultList();
	}
}


