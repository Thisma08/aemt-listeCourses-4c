package school.listecourses.exercicelistedecourses.application.product.commands.delete;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductRepository;

@Service
public class ProductDeleteHandler implements ICommandHandler<ProductDeleteCommand, ProductDeleteOutput> {
    private final IProductRepository repository;

    public ProductDeleteHandler(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductDeleteOutput handle(ProductDeleteCommand command) {
        long id = command.getId();
        if(!repository.existsById(id)) {
            return new ProductDeleteOutput(false, "Product not found");
        } else  {
            repository.deleteById(id);
            return new ProductDeleteOutput(true, "Product deleted successfully");
        }
    }
}
