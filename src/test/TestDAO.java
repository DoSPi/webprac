package test;
import entity.*;
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
		session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
	}
	@Test
	public void testGet() throws Exception
	{
		tx = session.beginTransaction();
		AccountDao acc = new AccountDao();
		Account x = acc.get(1);
		Assert.assertEquals(x.getAccount_id(),1);
		tx.commit();
	}
	@Test(expectedExceptions = Exception.class)
	public void testGetEx() throws Exception
	{
		tx = session.beginTransaction();
		AccountDao acc = new AccountDao();
		acc.get(1000);
		tx.commit();
	}
	@Test
	public void testSave() throws Exception
	{
		tx = session.beginTransaction();
		DepartmentDao dep = new DepartmentDao();
		Department x = new Department("aaa", "bbbb");
		dep.save(x);
		Department t = dep.get(3);
		Assert.assertEquals(x, t);
		tx.commit();
	}
	@Test
	public void testAccount()
	{
		tx = session.beginTransaction();
		System.out.print(session);
		AccountDao acc = new AccountDao();
		int size = acc.getAll().size();
		Assert.assertEquals(size, 3);
		Account t = acc.get(0);
		acc.delete(t);
		size = acc.getAll().size();
		Assert.assertEquals(size, 2);
		tx.commit();
	}
} 
