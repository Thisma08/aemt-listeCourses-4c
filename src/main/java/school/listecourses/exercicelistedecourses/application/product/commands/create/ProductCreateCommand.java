package school.listecourses.exercicelistedecourses.application.product.commands.create;

import lombok.Getter;

@Getter
public class ProductCreateCommand {
    public String name;
    public float price;
    public long categoryId;
}
