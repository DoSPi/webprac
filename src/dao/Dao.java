package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import utils.HibernateSessionFactoryUtil;
import java.lang.reflect.ParameterizedType;
public class Dao<T> {
	private final Class<T> type;
	Session session;
	public Dao(){
		 this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	 }
	public T get(long id) {
		return session.get(type, id);

	}

	public void save(T t) {
        session.save(t);
	}

	public void update(T t, String[] params) {
        session.update(t);
	}
	public void delete(T t) {
        session.delete(t);
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public List<T> getAll() {
        CriteriaBuilder builder =session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);     
        return session.createQuery(criteria).getResultList();
    }
}