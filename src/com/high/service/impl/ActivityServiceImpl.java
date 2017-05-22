package com.high.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.high.entity.Activity;
import com.high.mapper.ActivityMapper;
import com.high.service.ActivityService;
import com.high.service.LocationService;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	private ActivityMapper activityMapper;
	@Autowired
	private LocationService locationService; 
	
	@Override
	public void createActivity(Activity activity) {
		// TODO 实现创建 活动的 功能
		
		//判断必要的域是否为空，并进行数据校验
		
		//从session中取出 用户信息
		
		//插入活动地址，并获得地址id
		locationService.insertLocation(activity.getActivityLocation());
		activity.setActivityLocationId(activity.getActivityLocation().getLocationId());
		//是否有距离限制，若有则获得用户当前位置，并插入数据库，且获得id
		if(activity.getDistance() != null && activity.getDistance() >0){
			locationService.insertLocation(activity.getCreatorLocation());
			activity.setCreatorLocationId(activity.getCreatorLocation().getLocationId());
		}
		//将活动添加到数据库，并获得id，返回
		activity.setActivityId(UUID.randomUUID().toString());
		activityMapper.insertActivity(activity);
	}

}
