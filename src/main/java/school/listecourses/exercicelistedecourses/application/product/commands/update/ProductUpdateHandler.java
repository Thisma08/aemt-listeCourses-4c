package school.listecourses.exercicelistedecourses.application.product.commands.update;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductRepository;

@Service
public class ProductUpdateHandler implements ICommandHandler<ProductUpdateCommand, ProductUpdateOutput> {
    private final IProductRepository repository;

    public ProductUpdateHandler(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductUpdateOutput handle(ProductUpdateCommand command) {
        var product = repository.findById(command.getId());

        if(product.isPresent()) {
            var existingProduct = product.get();
            existingProduct.setName(command.getNewName());
            existingProduct.setPrice(command.getNewPrice());
            existingProduct.setCategoryId(command.getNewCategoryId());
            repository.save(existingProduct);

            return new ProductUpdateOutput(true, "Product updated successfully");
        } else {
            return new ProductUpdateOutput(false, "Product not found");
        }
    }
}
