package school.listecourses.exercicelistedecourses.controller.productCategory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.listecourses.exercicelistedecourses.application.productCategory.queries.ProductCategoryQueryProcessor;
import school.listecourses.exercicelistedecourses.application.productCategory.queries.getAll.ProductCategoryGetAllOutput;
import school.listecourses.exercicelistedecourses.application.productCategory.queries.getAll.ProductCategoryGetAllQuery;

@RestController
@RequestMapping("/product-categories")
public class ProductCategoryQueryController {
    private final ProductCategoryQueryProcessor productCategoryQueryProcessor;

    public ProductCategoryQueryController(ProductCategoryQueryProcessor productCategoryQueryProcessor) {
        this.productCategoryQueryProcessor = productCategoryQueryProcessor;
    }

    @GetMapping
    public Iterable<ProductCategoryGetAllOutput.ProductCategory> getAll(ProductCategoryGetAllQuery query) {
        return productCategoryQueryProcessor.getAll(query).productCategories;
    }
}
