package school.listecourses.exercicelistedecourses.application.product.commands.delete;

import lombok.Getter;

@Getter
public class ProductDeleteOutput {
    private final boolean success;
    private final String message;

    public ProductDeleteOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
