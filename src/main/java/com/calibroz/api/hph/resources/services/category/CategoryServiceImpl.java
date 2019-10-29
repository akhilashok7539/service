package com.calibroz.api.hph.resources.services.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calibroz.api.jpa.entities.category.Category;
import com.calibroz.api.repository.category.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		
		List<Category> categories = (List<Category>) categoryRepository.findAll();
		return categories;
	}

	@Override
	public Category getPlaceholder(String categoryName) {
		// TODO Auto-generated method stub
		
		Category category = categoryRepository.findByCategoryName(categoryName);
		return category;
	}

}
