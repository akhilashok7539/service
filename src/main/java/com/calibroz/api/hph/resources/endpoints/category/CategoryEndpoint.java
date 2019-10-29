package com.calibroz.api.hph.resources.endpoints.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.calibroz.api.hph.resources.services.category.CategoryService;
import com.calibroz.api.jpa.entities.category.Category;

@RestController 
@RequestMapping("/category")
public class CategoryEndpoint {
	
	@Autowired
	private CategoryService categoryService;
	
	//get category - all
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCategories(UriComponentsBuilder ucBuilder){
		
		System.out.println("hit1");
		List<Category> categories = categoryService.getAllCategory();
		System.out.println("hit2");
		List<String> showCategory=new ArrayList<String>();
		
				for (Category category: categories) {
					showCategory.add(category.getCategoryName());
			      }
		
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(ucBuilder.path("/category").buildAndExpand().toUri());
				return new ResponseEntity<List<String>>(showCategory, headers, HttpStatus.OK);
	
	}
	
	//get placeholder specific to category
	
	@RequestMapping(value = "/{categoryName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPlaceholder(@PathVariable("categoryName") String categoryName, UriComponentsBuilder ucBuilder){
		
		System.out.println("hit1");
		Category category = categoryService.getPlaceholder(categoryName);
		System.out.println("hit2");
		
		String placeholder = category.getPlaceholder();
		
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(ucBuilder.path("/category").buildAndExpand().toUri());
				return new ResponseEntity<String>(placeholder, headers, HttpStatus.OK);
	
	}
	
//	@RequestMapping(value = "/{categoryName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Category> getPlaceholder(@PathVariable("categoryName") String categoryName, UriComponentsBuilder ucBuilder){
//		
//		System.out.println("hit1");
//		Category category = categoryService.getPlaceholder();
//		System.out.println("hit2");
//		
////		String placeholder = category.getPlaceholder();
//		
//				HttpHeaders headers = new HttpHeaders();
//				headers.setLocation(ucBuilder.path("/category").buildAndExpand().toUri());
//				return new ResponseEntity<Category>(category, headers, HttpStatus.OK);
//	
//	}

}
