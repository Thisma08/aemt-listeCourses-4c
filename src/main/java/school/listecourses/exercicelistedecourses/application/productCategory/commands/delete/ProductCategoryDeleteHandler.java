package school.listecourses.exercicelistedecourses.application.productCategory.commands.delete;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete.ShoppingListDeleteOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductCategoryRepository;

@Service
public class ProductCategoryDeleteHandler implements ICommandHandler<ProductCategoryDeleteCommand, ProductCategoryDeleteOutput> {
    private final IProductCategoryRepository repository;

    public ProductCategoryDeleteHandler(IProductCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductCategoryDeleteOutput handle(ProductCategoryDeleteCommand command) {
        Long id = command.getId();
        if(!repository.existsById(id)) {
            return new ProductCategoryDeleteOutput(false, "Product category not found.");
        } else {
            repository.deleteById(id);
            return new ProductCategoryDeleteOutput(true, "Product category deleted successfully.");
        }
    }
}
