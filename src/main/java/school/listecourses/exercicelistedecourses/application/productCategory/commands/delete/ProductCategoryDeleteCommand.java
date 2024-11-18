package school.listecourses.exercicelistedecourses.application.productCategory.commands.delete;

import lombok.Getter;

@Getter
public class ProductCategoryDeleteCommand {
    private final Long id;

    public ProductCategoryDeleteCommand(Long id) {
        this.id = id;
    }
}
