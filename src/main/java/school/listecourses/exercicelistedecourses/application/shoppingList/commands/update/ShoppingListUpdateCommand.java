package school.listecourses.exercicelistedecourses.application.shoppingList.commands.update;

import lombok.Getter;

@Getter
public class ShoppingListUpdateCommand {
    private final long id;
    private final String newName;
    private final String newDescription;

    public ShoppingListUpdateCommand(long id, String newName, String newDescription) {
        this.id = id;
        this.newName = newName;
        this.newDescription = newDescription;
    }
}
