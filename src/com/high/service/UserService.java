package com.high.service;

import java.util.List;

import com.high.entity.User;

public interface UserService {
	void insertUser(User user);
	List<User> selectAllUser();
	void addUser(User user);
}
