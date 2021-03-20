package com.rsp.dao;

import java.util.List;

import com.rsp.model.User;

public interface UserDAO {
	void insert(User user);
	void insertBatch(List<User> users);
	List<User> findAllUsers();
	void cleanUp();
	User findByEmail(String email);
}
