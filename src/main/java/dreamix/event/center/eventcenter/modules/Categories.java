package dreamix.event.center.eventcenter.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
public class Categories extends IdSubClass{

    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Categories parentCategory;

    @OneToMany(mappedBy = "parentCategory", orphanRemoval = true)
    private List<Categories> subcategories;
    @OneToMany(mappedBy = "category")
    private Set<Event> events;
}