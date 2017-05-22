package com.high.mapper;

import java.util.List;

import com.high.entity.Category;


public interface CategoryMapper {

	List<String> findAllTopCategoryName();

	List<Category> findSecCateByTopCateName(String topCategory);
}
