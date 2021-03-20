package com.rsp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsp.dao.UserDAOImpl;
import com.rsp.model.User;

@Service("userDaoHelper")
public class UserDAOHelper {
	
	@Autowired
	UserDAOImpl userDaoImpl;
	public void addMultipleUsers(){
		User usr1 = new User();
		usr1.setFirstname("rahul");
		usr1.setLastname("patil");
		usr1.setEmail("rspatil45@gmail.com");
		usr1.setPassword("123");
		
		User usr2 = new User();
		usr2.setFirstname("ashoka");
		usr2.setLastname("king");
		usr2.setEmail("ashoka@world.com");
		usr2.setPassword("1234");
		
		User usr3 = new User();
		usr3.setFirstname("pruthvi");
		usr3.setLastname("raj");
		usr3.setEmail("pruthvi@world.com");
		usr3.setPassword("12345");

		User usr4 = new User();
		usr4.setFirstname("gautam");
		usr4.setLastname("buddha");
		usr4.setEmail("gautam@world.com");
		usr4.setPassword("123456");
		
		User usr5 = new User();
		usr5.setFirstname("vishnu");
		usr5.setLastname("bhagwan");
		usr5.setEmail("vishnu@world.com");
		usr5.setPassword("1234567");
		
		List<User> users = new ArrayList<User>();
		users.add(usr1);
		users.add(usr2);
		users.add(usr3);
		users.add(usr4);
		users.add(usr5);
		
		userDaoImpl.insertBatch(users);
	}

	
	public void printUserList(List<User> userList) {
		for(User user: userList)
		{
			System.out.println(user.toString());
		}
		
	}
	
	public void printUser(User user)
	{
		System.out.println(user.toString());
	}
}
