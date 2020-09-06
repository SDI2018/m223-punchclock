package ch.zli.m223.punchclock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	
	public Category createKategorie(Category category) {
		return categoryRepository.saveAndFlush(category);
	}

	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
}
