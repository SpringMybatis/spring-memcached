package com.ibs.zj.multi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ibs.zj.mem.model.User;
import com.ibs.zj.mem.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/META-INF/spring/applicationContext*.xml" })
public class TestMemCached {

	@Autowired
	private UserService userService;
	
	@Test
	public void TestUsers() {

		System.out.println("hello....");
		

		User u = new User();
		u.setUserId("2");
		u.setUsername("钟俊");
		u.setPassword("testUser");

		userService.saveUser(u);

		User u1 = userService.getById("2");
		System.out.println(u1.getUsername());

		u.setUsername("LeLe");
		userService.updateUser(u);

		User u2 = userService.getById("2");
		System.out.println(u2.getUsername());

	}

}
