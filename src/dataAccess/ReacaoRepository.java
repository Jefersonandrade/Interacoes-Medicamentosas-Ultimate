package dataAccess;

import domainModel.Reacao;
import java.util.List;
import javax.persistence.*;

public class ReacaoRepository
{
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public ReacaoRepository() {
		factory = Persistence.createEntityManagerFactory("InteracoesMedicamentosas"); 
		manager = factory.createEntityManager();
		
	}
	
	public void Save(Reacao obj) throws Exception {
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
	
	public void Delete(Reacao obj) throws Exception {
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
	
	public Reacao Open(int id) throws Exception {
		try {
			return manager.find(Reacao.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName() {
		return manager.createQuery("select r from Reacao r order by r.nome")
		.setMaxResults(10).getResultList();
	}
	
	public List getAllByName() {
		return manager.createQuery("select r from Reacao r order by r.nome")
		.getResultList();
	}

}
