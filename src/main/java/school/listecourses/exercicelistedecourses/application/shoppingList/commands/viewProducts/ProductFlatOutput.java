package school.listecourses.exercicelistedecourses.application.shoppingList.commands.viewProducts;

import lombok.Data;


@Data
public class ProductFlatOutput {
    private Long id;
    private String name;
    private float price;

    public ProductFlatOutput(Long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
