package com.webosmotic.HibernateCrudDemo.dao;

import java.util.List;

import com.webosmotic.HibernateCrudDemo.modal.User;

public interface UserDao {
	
	void saveUser(User user);
	
	User getUserById(String id);
	
	List<User> getAllUser();
	
	void updateUser(User user);
	
	void deleteByUserId(String id);

}
