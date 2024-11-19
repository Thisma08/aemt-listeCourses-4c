package school.listecourses.exercicelistedecourses.application.shoppingList.commands.dissociateProduct;

import lombok.Getter;

@Getter
public class ShoppingListDissociateProductCommand {
    private final Long productId;
    private final Long listId;

    public ShoppingListDissociateProductCommand(Long productId, Long listId) {
        this.productId = productId;
        this.listId = listId;
    }
}
