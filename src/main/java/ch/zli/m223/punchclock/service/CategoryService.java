package ch.zli.m223.punchclock.service;

import java.util.List;

import ch.zli.m223.punchclock.domain.Entry;
import org.springframework.stereotype.Service;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.repository.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}


	public Category createCategory(Category category) { return categoryRepository.saveAndFlush(category);
	}

	public Category findById(Long id){ return categoryRepository.getOne(id);}

	public void deleteCategory(Long id){categoryRepository.deleteById(id);}

	public Category updateCategory(Category category){
		if (categoryRepository.findById(category.getId())!=null){
			return categoryRepository.save(category);
		}
		return null;
	}
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}

}
