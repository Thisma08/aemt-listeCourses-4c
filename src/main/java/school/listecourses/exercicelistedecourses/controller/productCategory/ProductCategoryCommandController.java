package school.listecourses.exercicelistedecourses.controller.productCategory;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.ProductCategoryCommandProcessor;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.create.ProductCategoryCreateCommand;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.create.ProductCategoryCreateOutput;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.delete.ProductCategoryDeleteCommand;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.delete.ProductCategoryDeleteOutput;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.update.ProductCategoryUpdateCommand;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.update.ProductCategoryUpdateOutput;
import school.listecourses.exercicelistedecourses.application.productCategory.commands.update.ProductCategoryUpdateRequest;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateRequest;

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

    @PutMapping("/{id}")
    public ProductCategoryUpdateOutput updateProductCategory(@PathVariable long id, @RequestBody ProductCategoryUpdateRequest request) {
        ProductCategoryUpdateCommand command = new ProductCategoryUpdateCommand(id, request.getNewName());
        return productCategoryCommandProcessor.update(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductCategoryDeleteOutput> delete(@PathVariable long id) {
        ProductCategoryDeleteCommand command = new ProductCategoryDeleteCommand(id);
        ProductCategoryDeleteOutput output = productCategoryCommandProcessor.delete(command);

        if (output.isSuccess()) {
            return ResponseEntity.ok(output);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(output);
        }
    }
}
