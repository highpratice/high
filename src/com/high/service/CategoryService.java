package com.high.service;

import java.util.List;

public interface CategoryService {
	
	/**
	 * 获得所有顶级分类得名字
	 * @return 保存有所有分类名字的链表
	 */
	public List<String> findAllTopCategoryName();
	
	/**
	 * 通过顶级分类的名字获得该分类下所有的次级分类
	 * @param name
	 * @return
	 */
	List<String> findSecCateNameByTopCateName(String name) throws IllegalArgumentException;
}
