package school.listecourses.exercicelistedecourses.application.shoppingList.commands.update;

import lombok.Getter;

@Getter
public class ShoppingListUpdateOutput {
    private final boolean success;
    private final String message;

    public ShoppingListUpdateOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
