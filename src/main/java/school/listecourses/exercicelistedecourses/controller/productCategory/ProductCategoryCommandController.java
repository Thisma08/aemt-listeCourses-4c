package school.listecourses.exercicelistedecourses.controller.productCategory;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.ProductCategoryCommandProcessor;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.create.ProductCategoryCreateCommand;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.create.ProductCategoryCreateOutput;

@RestController
@RequestMapping("/product-categories")
public class ProductCategoryCommandController {
    private final ProductCategoryCommandProcessor productCategoryCommandProcessor;

    public ProductCategoryCommandController(ProductCategoryCommandProcessor productCategoryCommandProcessor) {
        this.productCategoryCommandProcessor = productCategoryCommandProcessor;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201")
    public ProductCategoryCreateOutput create(@RequestBody ProductCategoryCreateCommand command) {
        return productCategoryCommandProcessor.create(command);
    }
}
