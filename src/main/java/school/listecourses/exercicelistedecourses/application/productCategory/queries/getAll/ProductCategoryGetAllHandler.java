package school.listecourses.exercicelistedecourses.application.productCategory.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductCategoryRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProductCategory;

@Service
public class ProductCategoryGetAllHandler implements IQueryHandler<ProductCategoryGetAllQuery, ProductCategoryGetAllOutput> {
    private final IProductCategoryRepository repository;
    private final ModelMapper modelMapper;

    public ProductCategoryGetAllHandler(IProductCategoryRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductCategoryGetAllOutput handle(ProductCategoryGetAllQuery query) {
        Page<DbProductCategory> dbProductCategories = repository.findAll(PageRequest.of(query.page, query.pageSize));
        ProductCategoryGetAllOutput output = new ProductCategoryGetAllOutput();

        for(DbProductCategory dbProductCategory : dbProductCategories) {
            ProductCategoryGetAllOutput.ProductCategory productCategory = modelMapper.map(dbProductCategory, ProductCategoryGetAllOutput.ProductCategory.class);
            output.productCategories.add(productCategory);
        }
        return output;
    }
}
