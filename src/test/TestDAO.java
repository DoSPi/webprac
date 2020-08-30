package test;
import org.hibernate.Session;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Transaction;
import dao.*;
public class TestDAO {
	private Session session;
	private Transaction tx;
	public TestDAO(){
		//session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
	}
	@Test
	public void testAccount()
	{
		//tx = session.beginTransaction();
		//AccountDao acc = new AccountDao();
		//int size = acc.getAll().size();
		//Assert.assertEquals(size, 3);
		//tx.commit();
	}
} 
