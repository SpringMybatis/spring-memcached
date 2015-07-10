package com.ibs.zj.multi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ibs.zj.mem.dao.UserDAO;
import com.ibs.zj.mem.dao.impl.UserDAOImpl;
import com.ibs.zj.mem.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/META-INF/spring/applicationContext*.xml"})
public class TestSpringJunit4 {

	@Test
	public void saveUser() throws Exception {
		System.out.println("hello....");
		
		User u = new User();
		u.setUserId("1");
		u.setUsername("钟俊");
		u.setPassword("testUser");
		
		UserDAO userDAO = new UserDAOImpl();
		userDAO.saveUser(u);
		
		User u1 = userDAO.getById("1");
		System.out.println(u1.getUsername());
		
		u.setUsername("LeLe");
		userDAO.saveUser(u);
		
		User u2 = userDAO.getById("1");
		System.out.println(u2.getUsername());
		
	}
	
}
