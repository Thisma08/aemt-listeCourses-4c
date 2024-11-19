package school.listecourses.exercicelistedecourses.application.shoppingList.commands.dissociateProduct;

import lombok.Getter;

@Getter
public class ShoppingListDissociateProductOutput {
    private final boolean success;
    private final String message;

    public ShoppingListDissociateProductOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
