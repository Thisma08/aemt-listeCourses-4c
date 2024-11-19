package school.listecourses.exercicelistedecourses.controller.product;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.application.product.commands.ProductCommandProcessor;
import school.listecourses.exercicelistedecourses.application.product.commands.create.ProductCreateCommand;
import school.listecourses.exercicelistedecourses.application.product.commands.create.ProductCreateOutput;
import school.listecourses.exercicelistedecourses.application.product.commands.delete.ProductDeleteCommand;
import school.listecourses.exercicelistedecourses.application.product.commands.delete.ProductDeleteOutput;
import school.listecourses.exercicelistedecourses.application.product.commands.update.ProductUpdateCommand;
import school.listecourses.exercicelistedecourses.application.product.commands.update.ProductUpdateOutput;
import school.listecourses.exercicelistedecourses.application.product.commands.update.ProductUpdateRequest;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.delete.ProductCategoryDeleteCommand;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.delete.ProductCategoryDeleteOutput;

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

    @PutMapping("/{id}")
    public ProductUpdateOutput update(@PathVariable long id, @RequestBody ProductUpdateRequest request) {
        ProductUpdateCommand command = new ProductUpdateCommand(id, request.getNewName(), request.getNewPrice(), request.getNewCategoryId());
        return productCommandProcessor.update(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDeleteOutput> delete(@PathVariable long id) {
        ProductDeleteCommand command = new ProductDeleteCommand(id);
        ProductDeleteOutput output = productCommandProcessor.delete(command);

        if (output.isSuccess()) {
            return ResponseEntity.ok(output);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(output);
        }
    }
}
