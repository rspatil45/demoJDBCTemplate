package com.rsp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rsp.dao.UserDAOImpl;
import com.rsp.model.UserBean;

public class DemoJDBCTTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("application context loades ...");

		UserDAOImpl userDAO = context.getBean("userDao", UserDAOImpl.class);

		UserBean usr = new UserBean();
		usr.setFirstname("ashoka");
		usr.setLastname("king");
		usr.setEmail("ashoka@world.com");
		usr.setPassword("Nothing Impossible");

		// UserDAO userDAO = new UserDAOImpl();
		// userDAO.insert(usr);

		userDAO.insert(usr);
	}

}
