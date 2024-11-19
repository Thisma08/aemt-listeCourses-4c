package school.listecourses.exercicelistedecourses.application.shoppingList.commands.updateAssociation;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.dissociateProduct.ShoppingListDissociateProductCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.dissociateProduct.ShoppingListDissociateProductOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductListRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProductList;
import school.listecourses.exercicelistedecourses.infrastructure.embeddables.ProductListId;

@Service
public class ShoppingListUpdateAssociationHandler implements ICommandHandler<ShoppingListUpdateAssociationCommand, ShoppingListUpdateAssociationOutput> {
    private final IProductListRepository repository;

    public ShoppingListUpdateAssociationHandler(IProductListRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShoppingListUpdateAssociationOutput handle(ShoppingListUpdateAssociationCommand command) {
        ProductListId id = new ProductListId(command.getOldProductId(), command.getOldListId());

        var productList = repository.findById(id);

        if(productList.isPresent()) {
            repository.deleteById(id);
            DbProductList replacingDbProductList = new DbProductList(command.getNewProductId(), command.getNewListId());
            repository.save(replacingDbProductList);

            return new ShoppingListUpdateAssociationOutput(true, "Association updated successfully");
        } else {
            return new ShoppingListUpdateAssociationOutput(false, "Association not found");
        }

    }
}
