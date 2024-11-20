package school.listecourses.exercicelistedecourses.application.product.commands.create;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.controller.product.exceptions.DuplicateProductException;
import school.listecourses.exercicelistedecourses.domain.Product;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProduct;

@Service
public class ProductCreateHandler implements ICommandHandler<ProductCreateCommand, ProductCreateOutput> {
    private final IProductRepository repository;
    private final ModelMapper modelMapper;

    public ProductCreateHandler(IProductRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductCreateOutput handle(ProductCreateCommand command) {
        if(repository.existsByName(command.getName())) {
            throw new DuplicateProductException(command.getName());
        } else {
            Product product = new Product();
            product.setName(command.name);
            product.setPrice(command.price);
            product.setCategoryId(command.categoryId);

            DbProduct dbProduct = modelMapper.map(product, DbProduct.class);
            DbProduct dbProductCreated = repository.save(dbProduct);

            return modelMapper.map(dbProductCreated, ProductCreateOutput.class);
        }
    }
}
