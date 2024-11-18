package school.listecourses.exercicelistedecourses.application.shoppingList.commands.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingListUpdateRequest {
    private String newName;
    private String newDescription;
}
