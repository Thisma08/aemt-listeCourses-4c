package school.listecourses.exercicelistedecourses.application.product.commands.delete;

import lombok.Getter;

@Getter
public class ProductDeleteCommand {
    private final long id;

    public ProductDeleteCommand(long id) {
        this.id = id;
    }
}
