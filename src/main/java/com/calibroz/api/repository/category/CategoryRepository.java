package com.calibroz.api.repository.category;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.calibroz.api.jpa.entities.category.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>{

	Category findByCategoryName(String categoryName);
	
	

}
