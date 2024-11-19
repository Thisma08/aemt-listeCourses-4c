package school.listecourses.exercicelistedecourses.application.productCategory.commands.delete;

import lombok.Getter;

@Getter
public class ProductCategoryDeleteCommand {
    private final long id;

    public ProductCategoryDeleteCommand(long id) {
        this.id = id;
    }
}
