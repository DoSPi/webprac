package test;
import entity.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import dao.*;

public class TestDAO { 
	SessionFactory s;
	public TestDAO(){
		s = HibernateSessionFactoryUtil.getSessionFactory();
	}
	@Test(priority = 1)
	public void testGet() throws Exception
	{
		AccountDao acc = new AccountDao();
	    acc.setSessionFactory(s);
	    Transaction tx = acc.getSession().beginTransaction();
		Account x = acc.get(1l);
		Assert.assertNotEquals(x, null);
		Assert.assertEquals(x.getAccount_id(),1);
		Assert.assertEquals(x.getClient().getClient_id(),1);
		Assert.assertEquals(x.getClient().getName(),"Ivan ivanov");
		Assert.assertEquals(x.getBalance(),125.35);
		tx.commit();
	}
	@Test(priority = 2)
	public void testGetNull() throws Exception
	{
		AccountDao acc = new AccountDao();
	    acc.setSessionFactory(s);
	    Transaction tx = acc.getSession().beginTransaction();
		Account t = acc.get(1000l);
		Assert.assertEquals(t, null);
		tx.commit();
	}
	@Test(priority = 3)
	public void testGetAll() throws Exception
	{
		AccountDao acc = new AccountDao();
	    acc.setSessionFactory(s);
	    Transaction tx = acc.getSession().beginTransaction();
		List<Account> t = acc.getAll();
		Assert.assertEquals(t.size(), 3);
		Account x =t.get(0);
		Assert.assertEquals(x.getAccount_id(),1);
		Assert.assertEquals(x.getClient().getClient_id(),1);
		Assert.assertEquals(x.getClient().getName(),"Ivan ivanov");
		Assert.assertEquals(x.getBalance(),125.35);	
		tx.commit();
	} 
	@Test(priority = 4)
	public void testSave() throws Exception
	{
		DepartmentDao dep = new DepartmentDao();
		dep.setSessionFactory(s);
		Transaction tx = dep.getSession().beginTransaction();
		Department x = new Department("aaa", "bbbb");
		dep.save(x);
		Department t = dep.get(4l);
		Assert.assertEquals(x.getAddress(), t.getAddress());
		Assert.assertEquals(x.getName(), t.getName());
		tx.commit();
	} 
	@Test(priority = 5, expectedExceptions = Exception.class)
	public void testSaveEx() throws Exception
	{
		DepartmentDao dep = new DepartmentDao();
		dep.setSessionFactory(s);
		Transaction tx = dep.getSession().beginTransaction();
		Department x = new Department("aaa", "bbbb");
		x.setName(null);
		try {
			dep.save(x);
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
	} 
	
	@Test(priority = 6)
	public void testDelete()  throws Exception{
		TransactionDao t = new TransactionDao();
		t.setSessionFactory(s);
		Transaction tx = t.getSession().beginTransaction();
		int old = t.getAll().size();
		entity.Transaction tr = t.get(1l);
		Assert.assertNotNull(tr);
		Assert.assertEquals(tr.getTransaction_id(), 1);
		t.delete(tr);
		Assert.assertEquals(t.getAll().size(), old - 1);
		tx.commit();
	}
	@Test(priority = 7, expectedExceptions = Exception.class)
	public void testDeleteEx() throws Exception
	{
		DepartmentDao dep = new DepartmentDao();
		dep.setSessionFactory(s);
		Transaction tx = dep.getSession().beginTransaction();
		try {
			dep.delete(null);
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
	}  
	@Test(priority = 8)
	public void testUpdate() throws Exception
	{
		TypeDao dao = new TypeDao();
		dao.setSessionFactory(s);
		Transaction tx = dao.getSession().beginTransaction();
		entity.Type t =  dao.get(2l);
		Assert.assertEquals(t.getType_id(), 2);
		Assert.assertEquals(t.getName(), "debit");
		t.setName("testname");
		dao.update(t);
		entity.Type p =  dao.get(2l);
		Assert.assertEquals(p.getType_id(), 2);
		Assert.assertEquals(p.getName(), "testname");
		tx.commit();
	}
	@Test(priority = 9, expectedExceptions = Exception.class)
	public void testUpdateEx() throws Exception
	{
		TypeDao dao = new TypeDao();
		dao.setSessionFactory(s);
		Transaction tx = dao.getSession().beginTransaction();
		try {
			dao.update(null);
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
	}	
} 
