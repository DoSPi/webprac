package test;
import entity.*;
import org.hibernate.Session;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Transaction;
import dao.*;

public class TestDAO {
	private Session session;
	private Transaction tx;
	public TestDAO(){
	}
	@BeforeMethod
	public  void begin()
	{
		session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	@AfterMethod
	public void end()
	{
		tx.commit();
		session.close();
	}
	@Test(priority = 0)
	public void testGet() throws Exception
	{
		AccountDao acc = new AccountDao();
		acc.setSession(session);
		Account x = acc.get(1);
		Assert.assertEquals(x.getAccount_id(),1);
	}
	@Test(priority = 1, expectedExceptions = TestException.class)
	public void testGetEx() throws TestException
	{
		AccountDao acc = new AccountDao();
		acc.setSession(session);
		acc.get(1000);
	}
	@Test(priority = 2)
	public void testSave() throws Exception
	{
		DepartmentDao dep = new DepartmentDao();
		dep.setSession(session);
		Department x = new Department("aaa", "bbbb");
		dep.save(x);
		Department t = dep.get(4);
		Assert.assertEquals(x, t);
	}
	@Test(priority = 3)
	public void testAccount()
	{
		AccountDao acc = new AccountDao();
		acc.setSession(session);
		int size = acc.getAll().size();
		Assert.assertEquals(size, 3);
		Account t = acc.get(1);
		acc.delete(t);
		size = acc.getAll().size();
		Assert.assertEquals(size, 2);
	}
} 
