package com.high.service;

import com.high.entity.Activity;
import com.high.entity.SearchActivityQueryModel;
import com.high.entity.SearchActivityResultModel;

public interface ActivityService {

	/**
	 * 创建活动
	 * @param activity
	 */
	void createActivity(Activity activity);

	/**
	 * 搜索活动
	 * @param queryModel
	 * @return
	 */
	SearchActivityResultModel searchActivity(SearchActivityQueryModel queryModel);

}
