package test;
import entity.*;

import java.util.List;

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
	@Test(priority = 1)
	public void testGet() throws Exception
	{
		begin();
		AccountDao acc = new AccountDao();
		acc.setSession(session);
		Account x = acc.get(1l);
		Assert.assertEquals(x.getAccount_id(),1);
		Assert.assertEquals(x.getClient().getClient_id(),1);
		Assert.assertEquals(x.getClient().getName(),"Ivan ivanov");
		Assert.assertEquals(x.getBalance(),125.35);
		end();
	}
	@Test(priority = 2)
	public void testGetNull() throws Exception
	{
		begin();
		AccountDao acc = new AccountDao();
		acc.setSession(session);
		Account t = acc.get(1000l);
		Assert.assertEquals(t, null);
		end();
	}
	@Test(priority = 3)
	public void testGetAll() throws Exception
	{
		begin();
		AccountDao acc = new AccountDao();
		acc.setSession(session);
		List<Account> t = acc.getAll();
		Assert.assertEquals(t.size(), 3);
		Account x =t.get(0);
		Assert.assertEquals(x.getAccount_id(),1);
		Assert.assertEquals(x.getClient().getClient_id(),1);
		Assert.assertEquals(x.getClient().getName(),"Ivan ivanov");
		Assert.assertEquals(x.getBalance(),125.35);	
		end();
	} 
	@Test(priority = 4)
	public void testSave() throws Exception
	{
		begin();
		DepartmentDao dep = new DepartmentDao();
		dep.setSession(session);
		Department x = new Department("aaa", "bbbb");
		dep.save(x);
		Department t = dep.get(4l);
		Assert.assertEquals(x.getAddress(), t.getAddress());
		Assert.assertEquals(x.getName(), t.getName());
		end();
	} 
	@Test(priority = 5, expectedExceptions = Exception.class)
	public void testSaveEx() throws Exception
	{
		begin();
		DepartmentDao dep = new DepartmentDao();
		dep.setSession(session);
		Department x = new Department("aaa", "bbbb");
		x.setName(null);
		dep.save(x);
		end();
	}  
	@Test(priority = 6)
	public void testDelete()  throws Exception{
		begin();
		TransactionDao t = new TransactionDao();
		t.setSession(session);
		int old = t.getAll().size();
		entity.Transaction tr = t.get(1l);
		Assert.assertNotNull(tr);
		Assert.assertEquals(tr.getTransaction_id(), 1);
		t.delete(tr);
		Assert.assertEquals(t.getAll().size(), old - 1);
		end();
		
	}
	@Test(priority = 7, expectedExceptions = Exception.class)
	public void testDeleteEx() throws Exception
	{
		begin();
		DepartmentDao dep = new DepartmentDao();
		dep.setSession(session);
		dep.delete(null);
		end();
	}  
	/*@Test(priority = 7)
	public void testAccount() throws Exception
	{
		begin();
		AccountDao acc = new AccountDao();
		acc.setSession(session);
		int size = acc.getAll().size();
		Assert.assertEquals(size, 2);
		Account t = acc.get(2l);
		acc.delete(t);
		size = acc.getAll().size();
		//Assert.assertEquals(size, 2);
		end();
	} */
} 
