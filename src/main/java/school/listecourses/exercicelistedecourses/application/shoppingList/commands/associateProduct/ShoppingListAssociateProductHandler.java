package school.listecourses.exercicelistedecourses.application.shoppingList.commands.associateProduct;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductListRepository;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductRepository;
import school.listecourses.exercicelistedecourses.domain.interfaces.IShoppingListRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProduct;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProductList;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbShoppingList;

@Service
public class ShoppingListAssociateProductHandler implements ICommandHandler<ShoppingListAssociateProductCommand, ShoppingListAssociateProductOutput> {
    private final IProductRepository productRepository;
    private final IShoppingListRepository shoppingListRepository;
    private final IProductListRepository productListRepository;

    public ShoppingListAssociateProductHandler(IProductRepository productRepository, IShoppingListRepository shoppingListRepository, IProductListRepository productListRepository) {
        this.productRepository = productRepository;
        this.shoppingListRepository = shoppingListRepository;
        this.productListRepository = productListRepository;
    }

    @Override
    public ShoppingListAssociateProductOutput handle(ShoppingListAssociateProductCommand command) {
        long productId = command.getProductId();
        long listId = command.getListId();

        DbProduct dbProduct = productRepository.findById(productId).orElse(null);
        DbShoppingList dbShoppingList = shoppingListRepository.findById(listId).orElse(null);

        if(dbProduct == null || dbShoppingList == null) {
            return new ShoppingListAssociateProductOutput(false, "Product or shopping list not found");
        }

        DbProductList dbProductList = new DbProductList(productId, listId);
        productListRepository.save(dbProductList);

        return new ShoppingListAssociateProductOutput(true, "Product associated with list successfully");
    }
}
