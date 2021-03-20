package com.rsp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rsp.dao.UserDAOImpl;
import com.rsp.model.User;
import com.rsp.service.UserDAOHelper;

public class DemoJDBCTTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("application context loades ...");

		UserDAOImpl userDAO = context.getBean("userDao", UserDAOImpl.class);
		UserDAOHelper helper = context.getBean("userDaoHelper", UserDAOHelper.class);

		User usr = new User();
		usr.setFirstname("rahul");
		usr.setLastname("patil");
		usr.setEmail("pushyamitra@world.com");
		usr.setPassword("Nothing Impossible");

		// UserDAO userDAO = new UserDAOImpl();
		// userDAO.insert(usr);

		// helper.addMultipleUsers();

		// getting all user and printing
		// List<User> userList = userDAO.findAllUsers();
		// helper.printUserList(userList);
		
		//getting single user with email id, if multiple user having same email ,below method will give error
		User user = userDAO.findByEmail("vishnu@world.com");
		helper.printUser(user);
	}

}
