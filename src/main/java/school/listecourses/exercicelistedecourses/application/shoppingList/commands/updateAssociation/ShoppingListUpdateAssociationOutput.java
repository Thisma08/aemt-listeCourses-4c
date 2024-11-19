package school.listecourses.exercicelistedecourses.application.shoppingList.commands.updateAssociation;

import lombok.Getter;

@Getter
public class ShoppingListUpdateAssociationOutput {
    private final boolean success;
    private final String message;

    public ShoppingListUpdateAssociationOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
