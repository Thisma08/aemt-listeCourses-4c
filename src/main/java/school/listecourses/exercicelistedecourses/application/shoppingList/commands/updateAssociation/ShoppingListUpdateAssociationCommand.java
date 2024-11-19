package school.listecourses.exercicelistedecourses.application.shoppingList.commands.updateAssociation;

import lombok.Getter;
import school.listecourses.exercicelistedecourses.infrastructure.embeddables.ProductListId;

@Getter
public class ShoppingListUpdateAssociationCommand {
    private final long oldProductId;
    private final long oldListId;
    private final long newProductId;
    private final long newListId;

    public ShoppingListUpdateAssociationCommand(long oldProductId, long oldListId, long newProductId, long newListId) {
        this.oldProductId = oldProductId;
        this.oldListId = oldListId;
        this.newProductId = newProductId;
        this.newListId = newListId;
    }
}
