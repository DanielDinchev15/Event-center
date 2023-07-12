package dreamix.event.center.eventcenter.converter;

import dreamix.event.center.eventcenter.dto.CartDto;
import dreamix.event.center.eventcenter.dto.CategoriesDto;
import dreamix.event.center.eventcenter.modules.Cart;
import dreamix.event.center.eventcenter.modules.Categories;
import dreamix.event.center.eventcenter.services.CategoriesService;
import jdk.jfr.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriesConverter {
    @Autowired
    private CategoriesService categoriesService;

    public CategoriesDto convertEntityToDto(Categories categories) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categories, CategoriesDto.class);
    }

    public Categories convertDtoToEntity(CategoriesDto categoriesDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categoriesDto, Categories.class);
    }
}
