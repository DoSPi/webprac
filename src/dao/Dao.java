package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
@Transactional
public class Dao<T>{
	private final Class<T> type;
	@Autowired
	SessionFactory sessionFactory;
	public Dao(){
		 this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	 }
	public T get(Long  id) {
		return sessionFactory.getCurrentSession().get(type, id);

	}

	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}
	public void delete(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<T> getAll() {
        CriteriaBuilder builder =sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);     
        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }
}