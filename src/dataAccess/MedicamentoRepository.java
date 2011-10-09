package dataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import domainModel.Medicamento;

public class MedicamentoRepository {
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public MedicamentoRepository(){
		factory = Persistence.createEntityManagerFactory("InteracoesMedicamentosas");
		manager = factory.createEntityManager();
	}
	public void Save(Medicamento obj) throws Exception{
		try{
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
	public void Delete(Medicamento obj) throws Exception{
		try{
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
	public Medicamento Open(int id)throws Exception{
		try{
			return manager.find(Medicamento.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getTop10ByName(){
		return manager.createQuery("select m from Medicamento m order by m.nome")
		.setMaxResults(10).getResultList();
	}
	
	public List getAllbyName(){
		return manager.createQuery("select m from Medicamento m order by m.nome")
		.getResultList();
	}
}