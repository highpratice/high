package com.high.mapper;

import java.util.List;


public interface CategoryMapper {

	List<String> findAllTopCategoryName();

	List<String> findSecCateNameByTopCateName(String topCategory);
}
