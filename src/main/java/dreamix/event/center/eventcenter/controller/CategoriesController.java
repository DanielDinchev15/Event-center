package dreamix.event.center.eventcenter.controller;

import dreamix.event.center.eventcenter.converter.CategoriesConverter;
import dreamix.event.center.eventcenter.dto.CategoriesDto;
import dreamix.event.center.eventcenter.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoriesController {

    @Autowired
    private CategoriesService categoryService;
    @Autowired
    private CategoriesConverter categoriesConverter;

    @GetMapping("/all")
    public List<CategoriesDto> getAllCategories() {
        return categoryService.getCategories().stream().map(categories -> categoriesConverter.convertEntityToDto(categories)).collect(Collectors.toList());
    }

    @GetMapping("/category/{id}")
    public CategoriesDto getCategory(@PathVariable Long id) {
        if(categoryService.getCategoryById(id) == null){
            return null;
        }
        return categoriesConverter.convertEntityToDto(categoryService.getCategoryById(id));
    }
    @PostMapping("/add")
    public CategoriesDto createCategory(@RequestBody CategoriesDto categoriesDto) {
        return categoriesConverter.convertEntityToDto(categoryService.createCategory(categoriesConverter.convertDtoToEntity(categoriesDto)));
    }
    @PutMapping("/update/")
    public CategoriesDto updateCategory(@RequestBody CategoriesDto existingCategory) {
        return categoriesConverter.convertEntityToDto(categoryService.updateCategory(categoriesConverter.convertDtoToEntity(existingCategory)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
