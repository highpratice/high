package com.high.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.high.entity.User;
import com.high.service.UserService;

@Controller()
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/selectUser.do")
	public String selectUser(Model model){
		List<User> list = userService.selectAllUser();
		System.out.println(list);
		model.addAttribute("allUser", list);
		return "index";
	}
	@RequestMapping("/addUser.do")
	public String addUser(User user){
		System.out.println(user);
		userService.addUser(user);
		return "index";
	}
}
