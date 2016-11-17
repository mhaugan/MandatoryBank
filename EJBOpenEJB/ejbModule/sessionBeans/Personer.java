package sessionBeans;

import entity.Person;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import entity.Person;

/**
* Session Bean implementation class Personer
*/
@Stateful (name= "Personer")
public class Personer implements PersonerRemote {
	@PersistenceContext (unitName = "bankdb-unit", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	public Personer() {
	}
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public void add(Person person) throws Exception {
		entityManager.persist(person);
	}

	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public void remove(Person person) throws Exception {
		entityManager.remove(entityManager.merge(person));
	}

	@SuppressWarnings ("unchecked")
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public List <Person> list() throws Exception {
		Query query = entityManager.createQuery("SELECT p from Person as p");
		List <Person> l = query.getResultList();
		return l;
	}
}