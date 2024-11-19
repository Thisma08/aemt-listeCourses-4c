package school.listecourses.exercicelistedecourses.controller.shoppingList;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.ShoppingListCommandProcessor;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.associateProduct.ShoppingListAssociateProductCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.associateProduct.ShoppingListAssociateProductOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.create.ShoppingListCreateCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.create.ShoppingListCreateOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete.ShoppingListDeleteCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete.ShoppingListDeleteOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.dissociateProduct.ShoppingListDissociateProductCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.dissociateProduct.ShoppingListDissociateProductOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateRequest;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.updateAssociation.ShoppingListUpdateAssociationCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.updateAssociation.ShoppingListUpdateAssociationOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.updateAssociation.ShoppingListUpdateAssociationRequest;
import school.listecourses.exercicelistedecourses.infrastructure.embeddables.ProductListId;

@RestController
@RequestMapping("/shoppingLists")
public class ShoppingListCommandController {
    private final ShoppingListCommandProcessor shoppingListCommandProcessor;

    public ShoppingListCommandController(ShoppingListCommandProcessor shoppingListCommandProcessor) {
        this.shoppingListCommandProcessor = shoppingListCommandProcessor;
    }

    @PutMapping("/{id}")
    public ShoppingListUpdateOutput updateListeCourses(@PathVariable Long id, @RequestBody ShoppingListUpdateRequest request) {
        ShoppingListUpdateCommand command = new ShoppingListUpdateCommand(id, request.getNewName(), request.getNewDescription());
        return shoppingListCommandProcessor.update(command);
    }

    @PutMapping("/{listId}/products/{productId}")
    public ShoppingListUpdateAssociationOutput updateAssociation(@PathVariable Long listId, @PathVariable Long productId, @RequestBody ShoppingListUpdateAssociationRequest request) {
        ShoppingListUpdateAssociationCommand command = new ShoppingListUpdateAssociationCommand(productId, listId, request.getNewProductId(), request.getNewListId());
        return shoppingListCommandProcessor.updateAssociation(command);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201")
    public ShoppingListCreateOutput create(@RequestBody ShoppingListCreateCommand command) {
        return shoppingListCommandProcessor.create(command);
    }

    @PostMapping("/{id}/products")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201")
    public ShoppingListAssociateProductOutput associateProduct(@PathVariable Long id, @RequestParam long productId) {
        ShoppingListAssociateProductCommand command = new ShoppingListAssociateProductCommand(id, productId);
        return shoppingListCommandProcessor.associateProduct(command);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ShoppingListDeleteOutput> delete(@PathVariable Long id) {
        ShoppingListDeleteCommand command = new ShoppingListDeleteCommand(id);
        ShoppingListDeleteOutput output = shoppingListCommandProcessor.delete(command);

        if (output.isSuccess()) {
            return ResponseEntity.ok(output);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(output);
        }
    }

    @DeleteMapping("/{listId}/products/{productId}")
    public ResponseEntity<ShoppingListDissociateProductOutput> dissociateProduct(@PathVariable Long listId, @PathVariable Long productId) {
        ShoppingListDissociateProductCommand command = new ShoppingListDissociateProductCommand(productId, listId);
        ShoppingListDissociateProductOutput output = shoppingListCommandProcessor.dissociateProduct(command);

        if (output.isSuccess()) {
            return ResponseEntity.ok(output);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(output);
        }
    }
}
