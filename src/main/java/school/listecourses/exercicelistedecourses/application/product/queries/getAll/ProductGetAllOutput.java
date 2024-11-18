package school.listecourses.exercicelistedecourses.application.product.queries.getAll;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class ProductGetAllOutput {
    public List<Product> products = new ArrayList<>();

    @Data
    public static class Product {
        private long id;
        private String name;
        private float price;
        private long categoryId;
    }
}
