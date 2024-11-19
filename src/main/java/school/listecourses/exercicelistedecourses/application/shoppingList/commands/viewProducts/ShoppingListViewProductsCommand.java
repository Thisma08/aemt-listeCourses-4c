package school.listecourses.exercicelistedecourses.application.shoppingList.commands.viewProducts;

import lombok.Getter;

@Getter
public class ShoppingListViewProductsCommand {
    private final Long listId;
    private final String view;

    public ShoppingListViewProductsCommand(Long listId, String view) {
        this.listId = listId;
        this.view = view;
    }
}
