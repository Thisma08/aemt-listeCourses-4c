package school.listecourses.exercicelistedecourses.application.shoppingList.commands.updateAssociation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingListUpdateAssociationRequest {
    private long newProductId;
    private long newListId;
}
