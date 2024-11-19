package school.listecourses.exercicelistedecourses.application.product.commands.update;

import lombok.Getter;

@Getter
public class ProductUpdateOutput {
    private final boolean success;
    private final String message;

    public ProductUpdateOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
