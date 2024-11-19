package school.listecourses.exercicelistedecourses.application.shoppingList.commands.dissociateProduct;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductListRepository;
import school.listecourses.exercicelistedecourses.infrastructure.embeddables.ProductListId;

@Service
public class ShoppingListDissociateProductHandler implements ICommandHandler<ShoppingListDissociateProductCommand, ShoppingListDissociateProductOutput> {
    private final IProductListRepository repository;

    public ShoppingListDissociateProductHandler(IProductListRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShoppingListDissociateProductOutput handle(ShoppingListDissociateProductCommand command) {
        ProductListId id = new ProductListId(command.getProductId(), command.getListId());

        if(repository.existsById(id)) {
            repository.deleteById(id);
            return new ShoppingListDissociateProductOutput(true, "Product dissociated from list successfully");
        }

        return new ShoppingListDissociateProductOutput(false, "Association not found");
    }
}
