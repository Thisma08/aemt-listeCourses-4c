package school.listecourses.exercicelistedecourses.application.shoppingList.commands.associateProduct;

import lombok.Getter;

@Getter
public class ShoppingListAssociateProductOutput {
    private final boolean success;
    private final String message;

    public ShoppingListAssociateProductOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
