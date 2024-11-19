package school.listecourses.exercicelistedecourses.application.productCategory.commands.update;

import lombok.Getter;

@Getter
public class ProductCategoryUpdateCommand {
    private final long id;
    private final String newName;

    public ProductCategoryUpdateCommand(long id, String newName) {
        this.id = id;
        this.newName = newName;
    }
}
