package com.high.service.impl;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.high.entity.User;
import com.high.mapper.UserMapper;
import com.high.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public List<User> selectAllUser() {
		return userMapper.selectAllUser();
	}

	@Override
	public void addUser(User user) {
		UUID uuid = UUID.randomUUID();
		String userId = uuid.toString();
		System.out.println("userId: " + userId);
		user.setUserId(userId);
		userMapper.insertUser(user);
	}
}
