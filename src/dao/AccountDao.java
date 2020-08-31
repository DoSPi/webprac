package dao;
import entity.Account;
import entity.Type;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
public class AccountDao extends Dao<Account>{
	List<Account> getByClientId(long id){
		Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
	    TypedQuery<Account> query = session.createQuery(
	    		"SELECT a FROM account a WHERE account.client_id = :id);")
	    		.setParameter("id", id);
	        return query.getResultList();
	}
}
