package school.listecourses.exercicelistedecourses.application.product.queries;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.product.queries.getAll.ProductGetAllOutput;
import school.listecourses.exercicelistedecourses.application.product.queries.getAll.ProductGetAllQuery;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;

@Service
public class ProductQueryProcessor {
    private final IQueryHandler<ProductGetAllQuery, ProductGetAllOutput> productGetAllHandler;

    public ProductQueryProcessor(IQueryHandler<ProductGetAllQuery, ProductGetAllOutput> productGetAllHandler) {
        this.productGetAllHandler = productGetAllHandler;
    }

    public ProductGetAllOutput getAll(ProductGetAllQuery query) {
        return productGetAllHandler.handle(query);
    }
}
