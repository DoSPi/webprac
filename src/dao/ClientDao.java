package dao;

import entity.Client;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import entity.Account;
import utils.HibernateSessionFactoryUtil;
public class ClientDao extends Dao<Client>{
    public List<Account> getByClient(Long id) {
    	Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        TypedQuery<Account> query = session.createQuery(
                "SELECT e FROM account e " +
                        "WHERE e.client.client_id = :id")
                .setParameter("id", id);
        return query.getResultList();
    }
}
