package school.listecourses.exercicelistedecourses.application.shoppingList.commands.associateProduct;

import lombok.Getter;

@Getter
public class ShoppingListAssociateProductCommand {
    private final long listId;
    private final long productId;

    public ShoppingListAssociateProductCommand(long listId, long productId) {
        this.listId = listId;
        this.productId = productId;
    }
}
