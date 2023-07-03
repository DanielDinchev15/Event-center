package dreamix.event.center.eventcenter.services;

import dreamix.event.center.eventcenter.modules.Categories;
import dreamix.event.center.eventcenter.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository categoryRepository;

    public List<Categories> getCategories() {
        return categoryRepository.findAll();
    }
    public Categories getCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public Categories createCategory(Categories category){
        return categoryRepository.create(category);
    }
    public Categories updateCategory(Categories existingCategory) {
        return categoryRepository.update(existingCategory);
    }
    public void deleteCategory(Long id){
        categoryRepository.delete(id);
        getCategories();
    }
}
