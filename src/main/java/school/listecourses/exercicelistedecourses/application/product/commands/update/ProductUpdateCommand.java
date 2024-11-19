package school.listecourses.exercicelistedecourses.application.product.commands.update;

import lombok.Getter;

@Getter
public class ProductUpdateCommand {
    private final long id;
    private final String newName;
    private final float newPrice;
    private final long newCategoryId;

    public ProductUpdateCommand(long id, String newName, float newPrice, long newCategoryId) {
        this.id = id;
        this.newName = newName;
        this.newPrice = newPrice;
        this.newCategoryId = newCategoryId;
    }
}
