package school.listecourses.exercicelistedecourses.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private float price;
    private int categoryId;
}