package school.listecourses.exercicelistedecourses.application.product.commands.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateRequest {
    private String newName;
    private float newPrice;
    private long newCategoryId;
}
