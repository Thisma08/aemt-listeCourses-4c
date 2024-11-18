package school.listecourses.exercicelistedecourses.application.productCategory.commands.update;

import lombok.Getter;

@Getter
public class ProductCategoryUpdateCommand {
    private final Long id;
    private final String newName;

    public ProductCategoryUpdateCommand(Long id, String newName) {
        this.id = id;
        this.newName = newName;
    }
}
