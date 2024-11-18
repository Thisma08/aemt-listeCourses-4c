package school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete;

import lombok.Getter;

@Getter
public class ShoppingListDeleteCommand {
    private final Long id;

    public ShoppingListDeleteCommand(Long id) {
        this.id = id;
    }
}
