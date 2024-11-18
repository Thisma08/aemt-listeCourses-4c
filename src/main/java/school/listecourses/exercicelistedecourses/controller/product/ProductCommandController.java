package school.listecourses.exercicelistedecourses.controller.product;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.application.product.commands.ProductCommandProcessor;
import school.listecourses.exercicelistedecourses.application.product.commands.create.ProductCreateCommand;
import school.listecourses.exercicelistedecourses.application.product.commands.create.ProductCreateOutput;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
    private final ProductCommandProcessor productCommandProcessor;

    public ProductCommandController(ProductCommandProcessor productCommandProcessor) {
        this.productCommandProcessor = productCommandProcessor;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201")
    public ProductCreateOutput create(@RequestBody ProductCreateCommand command) {
        return productCommandProcessor.create(command);
    }
}
