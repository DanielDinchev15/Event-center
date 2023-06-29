package dreamix.event.center.eventcenter.services;

import dreamix.event.center.eventcenter.modules.Categories;
import dreamix.event.center.eventcenter.repository.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {
    @Autowired
    CategoriesRepo categoriesRepo;

    public void getCategory() {
        for (Categories category : categoriesRepo.findAll()) {
            System.out.println(category.getCategoryName());
        }
    }
    public void getCategoryById(Long id){
        Categories categories =  categoriesRepo.findById(id);
        System.out.println(categories.getCategoryName());
    }

    public void createCategory(Categories category){
        categoriesRepo.create(category);
    }
    public void updateCategories(Categories existingCategory) {
        categoriesRepo.update(existingCategory);
        getCategory();
    }
    public void deleteCategory(Long id){
        categoriesRepo.delete(id);
        getCategory();
    }
}
