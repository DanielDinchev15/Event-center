package dreamix.event.center.eventcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDto {
    private Long id;
    private String categoryName;
    private CategoriesDto parentCategory;
    private List<CategoriesDto> subCategory;
}
