package school.listecourses.exercicelistedecourses.controller.shoppingList;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.viewProducts.ShoppingListViewProductsHandler;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.ShoppingListQueryProcessor;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.getAll.ShoppingListGetAllOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.getAll.ShoppingListGetAllQuery;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.getById.ShoppingListGetByIdOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.searchByName.ShoppingListSearchByNameOutput;

@RestController
@RequestMapping("/shoppingLists")
public class ShoppingListQueryController {
    private final ShoppingListQueryProcessor shoppingListQueryProcessor;
    private final ShoppingListViewProductsHandler shoppingListViewProductsHandler;

    public ShoppingListQueryController(ShoppingListQueryProcessor shoppingListQueryProcessor, ShoppingListViewProductsHandler shoppingListViewProductsHandler) {
        this.shoppingListQueryProcessor = shoppingListQueryProcessor;
        this.shoppingListViewProductsHandler = shoppingListViewProductsHandler;
    }

    @GetMapping
    public Iterable<ShoppingListGetAllOutput.ShoppingList> getAll(ShoppingListGetAllQuery query) {
        return shoppingListQueryProcessor.getAll(query).shoppingLists;
    }

    @GetMapping(value = "/{id}")
    public ShoppingListGetByIdOutput getById(@PathVariable long id) {
        return shoppingListQueryProcessor.getById(id);
    }

    @GetMapping(value = "search/by-name/{name}")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400")
    })
    public ShoppingListSearchByNameOutput searchByName(@PathVariable() String name) {
        return shoppingListQueryProcessor.searchByName(name);
    }

    @GetMapping("/{id}/products")
    public Object getProducts(@PathVariable Long id, @RequestParam String view) {
        if ("flat".equalsIgnoreCase(view)) {
            return shoppingListViewProductsHandler.handleFlat(id);
        } else if ("complex".equalsIgnoreCase(view)) {
            return shoppingListViewProductsHandler.handleComplex(id);
        } else {
            throw new IllegalArgumentException("Invalid view type. Use 'flat' or 'complex'.");
        }
    }
}
