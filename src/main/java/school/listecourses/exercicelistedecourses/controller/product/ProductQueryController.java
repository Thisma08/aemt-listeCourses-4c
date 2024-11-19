package school.listecourses.exercicelistedecourses.controller.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.listecourses.exercicelistedecourses.application.product.queries.ProductQueryProcessor;
import school.listecourses.exercicelistedecourses.application.product.queries.getAll.ProductGetAllOutput;
import school.listecourses.exercicelistedecourses.application.product.queries.getAll.ProductGetAllQuery;

@RestController
@RequestMapping("/products")
public class ProductQueryController {
    private final ProductQueryProcessor productQueryProcessor;

    public ProductQueryController(ProductQueryProcessor productQueryProcessor) {
        this.productQueryProcessor = productQueryProcessor;
    }

    @GetMapping
    public Iterable<ProductGetAllOutput.Product> getAll(ProductGetAllQuery query) {
        return productQueryProcessor.getAll(query).products;
    }
}
