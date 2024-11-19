package school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete;

import lombok.Getter;

@Getter
public class ShoppingListDeleteCommand {
    private final long id;

    public ShoppingListDeleteCommand(long id) {
        this.id = id;
    }
}
