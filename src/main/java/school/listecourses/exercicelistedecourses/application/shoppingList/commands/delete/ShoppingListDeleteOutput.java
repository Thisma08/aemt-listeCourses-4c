package school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete;

import lombok.Getter;

@Getter
public class ShoppingListDeleteOutput {
    private final boolean success;
    private final String message;

    public ShoppingListDeleteOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
