package school.listecourses.exercicelistedecourses.application.productCategory.commands.update;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductCategoryRepository;

@Service
public class ProductCategoryUpdateHandler implements ICommandHandler<ProductCategoryUpdateCommand, ProductCategoryUpdateOutput> {
    private final IProductCategoryRepository repository;

    public ProductCategoryUpdateHandler(IProductCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductCategoryUpdateOutput handle(ProductCategoryUpdateCommand command) {
        var productCategory = repository.findById(command.getId());

        if(productCategory.isPresent()) {
            var existingProductCategory = productCategory.get();
            existingProductCategory.setName(command.getNewName());
            repository.save(existingProductCategory);

            return new ProductCategoryUpdateOutput(true, "Product category updated successfully.");
        } else {
            return new ProductCategoryUpdateOutput(false, "Product category not found.");
        }

    }
}
