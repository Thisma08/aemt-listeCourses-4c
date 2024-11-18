package school.listecourses.exercicelistedecourses.application.product.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IProductRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProduct;

@Service
public class ProductGetAllHandler implements IQueryHandler<ProductGetAllQuery, ProductGetAllOutput> {
    private final IProductRepository repository;
    private final ModelMapper modelMapper;

    public ProductGetAllHandler(IProductRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductGetAllOutput handle(ProductGetAllQuery query) {
        Page<DbProduct> dbProducts = repository.findAll(PageRequest.of(query.page, query.pageSize));
        ProductGetAllOutput output = new ProductGetAllOutput();

        for(DbProduct dbProduct : dbProducts) {
            ProductGetAllOutput.Product product = modelMapper.map(dbProduct, ProductGetAllOutput.Product.class);
            output.products.add(product);
        }

        return output;
    }
}
