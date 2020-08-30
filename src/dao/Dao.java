package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import utils.HibernateSessionFactoryUtil;
import java.lang.reflect.ParameterizedType;
public class Dao<T> {
	private final Class<T> type;
	public Dao(){
		 this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	 }
	public T get(long id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
		return session.get(type, id);

	}

	public void save(T t) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        session.save(t);
	}

	public void update(T t, String[] params) {
	    Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        session.update(t);
	}
	public void delete(T t) {
	    Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        session.delete(t);
	}


    public List<T> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        CriteriaBuilder builder =session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);     
        return session.createQuery(criteria).getResultList();
    }
}