package com.calibroz.api.hph.resources.services.category;

import java.util.List;

import com.calibroz.api.jpa.entities.category.Category;

public interface CategoryService {

	List<Category> getAllCategory();

	Category getPlaceholder(String categoryName);


}
