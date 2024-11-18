package school.listecourses.exercicelistedecourses.application.productCategory.commands.create;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.ProductCategory;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductCategoryRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProductCategory;

@Service
public class ProductCategoryCreateHandler implements ICommandHandler<ProductCategoryCreateCommand, ProductCategoryCreateOutput> {
    private final IProductCategoryRepository repository;
    private final ModelMapper modelMapper;

    public ProductCategoryCreateHandler(IProductCategoryRepository productCategoryRepository, ModelMapper modelMapper) {
        this.repository = productCategoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductCategoryCreateOutput handle(ProductCategoryCreateCommand command) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(command.name);

        DbProductCategory dbProductCategory = modelMapper.map(productCategory, DbProductCategory.class);
        DbProductCategory dbProductCategoryCreated = repository.save(dbProductCategory);

        return modelMapper.map(dbProductCategoryCreated, ProductCategoryCreateOutput.class);
    }
}

