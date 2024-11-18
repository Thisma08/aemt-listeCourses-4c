package school.listecourses.exercicelistedecourses.application.shoppingList.commands.update;

import lombok.Getter;

@Getter
public class ShoppingListUpdateCommand {
    private final Long id;
    private final String newName;
    private final String newDescription;

    public ShoppingListUpdateCommand(Long id, String newName, String newDescription) {
        this.id = id;
        this.newName = newName;
        this.newDescription = newDescription;
    }
}
