package school.listecourses.exercicelistedecourses.application.productCategory.queries;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.productCategory.queries.getAll.ProductCategoryGetAllHandler;
import school.listecourses.exercicelistedecourses.application.productCategory.queries.getAll.ProductCategoryGetAllOutput;
import school.listecourses.exercicelistedecourses.application.productCategory.queries.getAll.ProductCategoryGetAllQuery;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.getAll.ShoppingListGetAllOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.getAll.ShoppingListGetAllQuery;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;

@Service
public class ProductCategoryQueryProcessor {
    private final IQueryHandler<ProductCategoryGetAllQuery, ProductCategoryGetAllOutput> productCategoryGetAllHandler;

    public ProductCategoryQueryProcessor(IQueryHandler<ProductCategoryGetAllQuery, ProductCategoryGetAllOutput> productCategoryGetAllHandler) {
        this.productCategoryGetAllHandler = productCategoryGetAllHandler;
    }

    public ProductCategoryGetAllOutput getAll(ProductCategoryGetAllQuery query) {
        return productCategoryGetAllHandler.handle(query);
    }
}
