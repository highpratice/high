package com.high.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.high.entity.Activity;
import com.high.service.ActivityService;

@Controller
@RequestMapping("activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@RequestMapping("/createActivity.do")
	public String createActivity(Activity activity,Model model){
		activityService.createActivity(activity);
		model.addAttribute("activity", activity);
		return "activity/createSuccess";
	}
}
