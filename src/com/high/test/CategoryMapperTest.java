package com.high.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.high.mapper.CategoryMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class CategoryMapperTest {
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Test
	public void testFindSecCateNameByTopCateName(){
		String name = "运动";
		System.out.println("类别: " + name);
		List<String> names = categoryMapper.findSecCateNameByTopCateName(name);
		System.out.println(names);
	}

}
