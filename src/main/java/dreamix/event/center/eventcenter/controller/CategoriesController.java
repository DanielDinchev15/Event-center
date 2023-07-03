package dreamix.event.center.eventcenter.controller;

import dreamix.event.center.eventcenter.modules.Categories;
import dreamix.event.center.eventcenter.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoriesController {

    @Autowired
    private CategoriesService categoryService;

    @GetMapping("/all")
    public List<Categories> getAllCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/category/{id}")
    public Categories getCategory(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/add")
    public Categories createCategory(@RequestBody Categories categories){
        return categoryService.createCategory(categories);
    }

    @PutMapping("/update/")
    public Categories updateCategory(@RequestBody Categories existingCategory){
        return categoryService.updateCategory(existingCategory);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
