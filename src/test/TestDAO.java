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
	//@BeforeMethod
	public  void begin()
	{
		session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	//@AfterMethod
	public void end() throws Exception
	{
		tx.commit();
		session.close();
	}
	/*
	@Test(priority = 1)
	public void testGet() throws Exception
	{
		AccountDao acc = new AccountDao();
		acc.setSession(session);
		Account x = acc.get(1);
		Assert.assertEquals(x.getAccount_id(),1);
		end();
	}
	@Test(priority = 2)
	public void testGetNull() throws Exception
	{
		AccountDao acc = new AccountDao();
		acc.setSession(session);
		Account t = acc.get(1000);
		Assert.assertEquals(t, null);
		end();
	} 
	@Test(priority = 3)
	public void testSave() throws Exception
	{
		DepartmentDao dep = new DepartmentDao();
		dep.setSession(session);
		Department x = new Department("aaa", "bbbb");
		dep.save(x);
		Department t = dep.get(4);
		Assert.assertEquals(x.getAddress(), t.getAddress());
		Assert.assertEquals(x.getName(), t.getName());
		end();
	} 
	@Test(priority = 4, expectedExceptions = Exception.class)
	public void testSaveEx() throws Exception
	{
		DepartmentDao dep = new DepartmentDao();
		dep.setSession(session);
		Department x = new Department("aaa", "bbbb");
		x.setName(null);
		dep.save(x);
		end();
	}  */
	@Test(priority = 5)
	public void testDelete()  throws Exception{
		begin();
		TransactionDao t = new TransactionDao();
		t.setSession(session);
		entity.Transaction tr = t.get(1);
		Assert.assertNotNull(tr);
		//t.delete(tr);
		Assert.assertEquals(t.get(1).getTransaction_id(), 1);
		Assert.assertEquals(t.getAll().size(), 3);
		end();
		
	} /*
	@Test(priority = 6)
	public void testAccount() throws Exception
	{
		AccountDao acc = new AccountDao();
		acc.setSession(session);
		int size = acc.getAll().size();
		Assert.assertEquals(size, 3);
		Account t = acc.get(1);
		acc.delete(t);
		size = acc.getAll().size();
		Assert.assertEquals(size, 2);
		end();
	} */
} 
