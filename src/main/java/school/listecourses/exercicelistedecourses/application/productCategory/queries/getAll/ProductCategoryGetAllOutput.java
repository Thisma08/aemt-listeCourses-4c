package school.listecourses.exercicelistedecourses.application.productCategory.queries.getAll;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryGetAllOutput {
    public List<ProductCategory> productCategories = new ArrayList<>();

    @Data
    public static class ProductCategory {
        private long id;
        private String name;
    }
}
