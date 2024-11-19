package school.listecourses.exercicelistedecourses.application.shoppingList.commands.viewProducts;

import lombok.Data;

import java.util.List;

@Data
public class ProductComplexOutput {
    private String categoryName;
    private List<ProductFlatOutput> products;

    public ProductComplexOutput(String categoryName, List<ProductFlatOutput> products) {
        this.categoryName = categoryName;
        this.products = products;
    }
}
