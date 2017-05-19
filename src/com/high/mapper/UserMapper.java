package com.high.mapper;

import java.util.List;

import com.high.entity.User;

public interface UserMapper {
	void insertUser(User user);
	List<User> selectAllUser();
}
