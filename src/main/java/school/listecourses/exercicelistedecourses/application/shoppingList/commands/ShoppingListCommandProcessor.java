package school.listecourses.exercicelistedecourses.application.shoppingList.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.associateProduct.ShoppingListAssociateProductCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.associateProduct.ShoppingListAssociateProductOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.create.ShoppingListCreateCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.create.ShoppingListCreateOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete.ShoppingListDeleteCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete.ShoppingListDeleteOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.dissociateProduct.ShoppingListDissociateProductCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.dissociateProduct.ShoppingListDissociateProductOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.updateAssociation.ShoppingListUpdateAssociationCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.updateAssociation.ShoppingListUpdateAssociationOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class ShoppingListCommandProcessor {
    private final ICommandHandler<ShoppingListUpdateCommand, ShoppingListUpdateOutput> updateShoppingListHandler;
    private final ICommandHandler<ShoppingListCreateCommand, ShoppingListCreateOutput> createShoppingListHandler;
    private final ICommandHandler<ShoppingListDeleteCommand, ShoppingListDeleteOutput> deleteShoppingListHandler;
    private final ICommandHandler<ShoppingListAssociateProductCommand, ShoppingListAssociateProductOutput> associateProductHandler;
    private final ICommandHandler<ShoppingListDissociateProductCommand, ShoppingListDissociateProductOutput> dissociateProductHandler;
    private final ICommandHandler<ShoppingListUpdateAssociationCommand, ShoppingListUpdateAssociationOutput> updateAssociationHandler;

    public ShoppingListCommandProcessor(ICommandHandler<ShoppingListUpdateCommand, ShoppingListUpdateOutput> updateShoppingListHandler, ICommandHandler<ShoppingListCreateCommand, ShoppingListCreateOutput> createShoppingListHandler, ICommandHandler<ShoppingListDeleteCommand, ShoppingListDeleteOutput> deleteShoppingListHandler, ICommandHandler<ShoppingListAssociateProductCommand, ShoppingListAssociateProductOutput> associateProductHandler, ICommandHandler<ShoppingListDissociateProductCommand, ShoppingListDissociateProductOutput> dissociateProductHandler, ICommandHandler<ShoppingListUpdateAssociationCommand, ShoppingListUpdateAssociationOutput> updateAssociationHandler) {
        this.updateShoppingListHandler = updateShoppingListHandler;
        this.createShoppingListHandler = createShoppingListHandler;
        this.deleteShoppingListHandler = deleteShoppingListHandler;
        this.associateProductHandler = associateProductHandler;
        this.dissociateProductHandler = dissociateProductHandler;
        this.updateAssociationHandler = updateAssociationHandler;
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

    public ShoppingListDissociateProductOutput dissociateProduct(ShoppingListDissociateProductCommand command) {
        return dissociateProductHandler.handle(command);
    }

    public ShoppingListUpdateAssociationOutput updateAssociation(ShoppingListUpdateAssociationCommand command) {
        return updateAssociationHandler.handle(command);
    }
}
