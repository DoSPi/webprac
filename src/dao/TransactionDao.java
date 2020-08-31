package dao;
import entity.Transaction;
import utils.HibernateSessionFactoryUtil;
import entity.Account;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
public class TransactionDao extends Dao<Transaction>{
        public List<Transaction> getByAccount(Long id) {
        	Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            TypedQuery<Transaction> query = session.createQuery(
                    "SELECT t FROM transaction t " +
                            "WHERE t.account.accountId = :id")
                    .setParameter("id", id);
            return query.getResultList();
        }
    }