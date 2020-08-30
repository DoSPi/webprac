import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import utils.HibernateSessionFactoryUtil;
class Test{
public  static void main(String[] args)
{
    SessionFactory factory = HibernateSessionFactoryUtil.getSessionFactory();
}
}
