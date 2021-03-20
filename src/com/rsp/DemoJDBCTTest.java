package com.rsp;

import com.rsp.dao.UserDAO;
import com.rsp.dao.UserDAOImpl;
import com.rsp.model.UserBean;

public class DemoJDBCTTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBean usr = new UserBean();
		usr.setFirstname("pruthvi");
		usr.setLastname("Raj");
		usr.setEmail("pruthvi@world.com");
		usr.setPassword("All possible");
		
		UserDAO userDAO = new UserDAOImpl();
		userDAO.insert(usr);

	}

}
