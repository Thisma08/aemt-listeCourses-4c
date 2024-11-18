package school.listecourses.exercicelistedecourses.application.shoppingList.queries.getById;

import lombok.Data;

import java.util.Date;

@Data
public class ShoppingListGetByIdOutput {
    private long id;
    private String name;
    private String description;
    private Date createdAt;
}
