package com.itcast.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itcast.dao.UserDao;
import com.itcast.domain.User;
import com.itcast.service.UserService;



/**
 * 测试hibernate框架
 * @author Administrator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class HibernateTest {
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	
		
	/**
	 * 测试hibernate框架
	 */
	@Test
	public void fun1() {
		Configuration conf =new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//==================================
		User u = new User();
		//==================================
		u.setUser_code("devin");
		u.setUser_name("周舒");
		u.setUser_password("1234");
		session.save(u);
		tx.commit();
		session.close();
		sf.close();
	}
	
	
	/**
	 * 测试spring管理sessionFactory
	 */
	@Test
	public void fun2() {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//==================================
		User u = new User();
		//==================================
		u.setUser_code("liangchen");
		u.setUser_name("大铭");
		u.setUser_password("amo");
		session.save(u);
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun3() {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//==================================
		User u = new User();
		//==================================
		u.setUser_code("xq");
		u.setUser_name("小祺");
		u.setUser_password("666666");
		session.save(u);
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun4() {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//==================================
		User u = new User();
		//==================================
		u.setUser_code("danny");
		u.setUser_name("丹尼");
		u.setUser_password("666666");
		session.save(u);
		tx.commit();
		session.close();
	}
	

	/**
	 * 测试Dao hibernate模板
	 */
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	public void fun5() {		
		User u = ud.getByUserCode("liangchen");
		System.out.println(u);
	}
	
	@Resource(name="userService")
	private UserService us;
	//测试aop事务	
	@Test
	public void fun6() {	
		User u = new  User();
		u.setUser_code("sss");
		u.setUser_name("石石石");
		u.setUser_password("zhangtuhao");
		us.saveUser(u);
	}
	
	
}
