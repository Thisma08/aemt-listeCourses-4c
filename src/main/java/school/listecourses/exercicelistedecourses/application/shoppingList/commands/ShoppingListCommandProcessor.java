package school.listecourses.exercicelistedecourses.application.shoppingList.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.associateProduct.ShoppingListAssociateProductCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.associateProduct.ShoppingListAssociateProductOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.create.ShoppingListCreateCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.create.ShoppingListCreateOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete.ShoppingListDeleteCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete.ShoppingListDeleteOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class ShoppingListCommandProcessor {
    private final ICommandHandler<ShoppingListUpdateCommand, ShoppingListUpdateOutput> updateShoppingListHandler;
    private final ICommandHandler<ShoppingListCreateCommand, ShoppingListCreateOutput> createShoppingListHandler;
    private final ICommandHandler<ShoppingListDeleteCommand, ShoppingListDeleteOutput> deleteShoppingListHandler;
    private final ICommandHandler<ShoppingListAssociateProductCommand, ShoppingListAssociateProductOutput> associateProductHandler;



    public ShoppingListCommandProcessor(ICommandHandler<ShoppingListUpdateCommand, ShoppingListUpdateOutput> updateShoppingListHandler, ICommandHandler<ShoppingListCreateCommand, ShoppingListCreateOutput> createShoppingListHandler, ICommandHandler<ShoppingListDeleteCommand, ShoppingListDeleteOutput> deleteShoppingListHandler, ICommandHandler<ShoppingListAssociateProductCommand, ShoppingListAssociateProductOutput> associateProductHandler) {
        this.updateShoppingListHandler = updateShoppingListHandler;
        this.createShoppingListHandler = createShoppingListHandler;
        this.deleteShoppingListHandler = deleteShoppingListHandler;
        this.associateProductHandler = associateProductHandler;
    }

    public ShoppingListUpdateOutput update(ShoppingListUpdateCommand command) {
        return updateShoppingListHandler.handle(command);
    }

    public ShoppingListCreateOutput create(ShoppingListCreateCommand command) {
        return createShoppingListHandler.handle(command);
    }

    public ShoppingListDeleteOutput delete(ShoppingListDeleteCommand command) {
        return deleteShoppingListHandler.handle(command);
    }

    public ShoppingListAssociateProductOutput associateProduct(ShoppingListAssociateProductCommand command) {
        return associateProductHandler.handle(command);
    }
}
