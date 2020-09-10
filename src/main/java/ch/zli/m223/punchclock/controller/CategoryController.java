package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){this.categoryService = categoryService;}

    /**
     * Gibt eine Liste aller Category Datensätze zurück
     * @return List<Category>
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    /**
     * Erzeugt einen neuen category Datensatz
     * @param category
     * @return category
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@Valid @RequestBody Category category) { return categoryService.createCategory(category);
    }

    /**
     * Löscht einen bestehenden category Datensatz anhand der ID
     * @param id
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable("id") Long id){ categoryService.deleteCategory(id);}

    /**
     * Aktualisiert einen bestehenden category Datensatz
     * @param category
     * @return category
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Category updateCategory(@Valid @RequestBody Category category){ return categoryService.updateCategory(category);}


}
