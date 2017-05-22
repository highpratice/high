package com.high.test;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.high.entity.Activity;
import com.high.mapper.ActivityMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class ActivityMapperTest {
	
	@Autowired
	private ActivityMapper activityMapper;
	
	@Test
	public void demo1(){
		Activity activity = new Activity();
		activity.setActivityId(UUID.randomUUID().toString());
		activityMapper.insertActivity(activity);
	}

}
