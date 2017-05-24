package com.high.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.high.entity.Activity;
import com.high.entity.SearchActivityQueryModel;
import com.high.entity.SearchActivityResultModel;
import com.high.service.ActivityService;

@Controller
@RequestMapping("activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	/**
	 * 创建活动
	 * 
	 * @param activity
	 * @param model
	 * @return
	 */
	@RequestMapping("/createActivity.do")
	public String createActivity(Activity activity, Model model) {
		activityService.createActivity(activity);
		model.addAttribute("activity", activity);
		return "activity/createSuccess";
	}

	/**
	 * 通过搜索框搜索
	 * @param keyword
	 * @return
	 */
	@RequestMapping("/queryActivity.d0")
	public @ResponseBody SearchActivityResultModel queryActivity(SearchActivityQueryModel queryModel) {

		return activityService.searchActivity(queryModel);
	}
}
