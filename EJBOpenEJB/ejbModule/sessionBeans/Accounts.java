package sessionBeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import entity.Account;

/**
 * Session Bean implementation class Accounts
 */
@Stateless
@LocalBean
public class Accounts implements AccountsRemote {

	@PersistenceContext (unitName = "bankdb-unit", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	public Accounts() {
	}
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public void add(Account account) throws Exception {
		entityManager.persist(account);
	}

	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public void remove(Account account) throws Exception {
		entityManager.remove(entityManager.merge(account));
	}

	@SuppressWarnings ("unchecked")
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public List <Account> list() throws Exception {
		Query query = entityManager.createQuery("SELECT a from Account as a");
		List <Account> l = query.getResultList();
		return l;
	}

}
