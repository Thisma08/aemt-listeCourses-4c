package school.listecourses.exercicelistedecourses.application.productCategory.commands.delete;

import lombok.Getter;

@Getter
public class ProductCategoryDeleteOutput {
    private final boolean success;
    private final String message;

    public ProductCategoryDeleteOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
