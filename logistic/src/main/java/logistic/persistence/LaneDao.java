package logistic.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import logistic.common.Lane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class LaneDao implements LaneDaoInterface<Lane, String> {

	@Autowired
	@Qualifier("sessionFactory")
	private Session currentSession;

	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	private Transaction currentTransaction;

	public LaneDao() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		return HibernateUtil.getSessionFactory();
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Lane entity) {
		getCurrentSession().save(entity);
	}

	public void update(Lane entity) {
		getCurrentSession().update(entity);
	}

	public Lane findById(String id) {
		Lane Lane = (Lane) getCurrentSession().get(Lane.class, id);
		return Lane;
	}

	public void delete(Lane entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Lane> findAll() {
		List<Lane> Lanes = (List<Lane>) getCurrentSession().createQuery(
				"from Lane").list();
		return Lanes;
	}

	public void deleteAll() {
		List<Lane> entityList = findAll();
		for (Lane entity : entityList) {
			delete(entity);
		}
	}

	public List vertexList() {
		Set<String> vertex = new HashSet<String>();
		String hql = "from Lane";
		Query query = getCurrentSession().createQuery(hql);
		List<Lane> results = query.list();
		for (Lane lane : results) {
			vertex.add(lane.getDestination());
			vertex.add(lane.getSource());
		}
		List ret = new ArrayList(vertex);
		Collections.sort(ret);
		
		return ret;
	}
}
