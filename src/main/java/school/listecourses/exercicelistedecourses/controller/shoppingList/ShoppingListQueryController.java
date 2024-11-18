package school.listecourses.exercicelistedecourses.controller.shoppingList;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.ShoppingListQueryProcessor;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.getAll.ShoppingListGetAllOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.getAll.ShoppingListGetAllQuery;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.getById.ShoppingListGetByIdOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.searchByName.ShoppingListSearchByNameOutput;

@RestController
@RequestMapping("/shoppingLists")
public class ShoppingListQueryController {
    private final ShoppingListQueryProcessor shoppingListQueryProcessor;

    public ShoppingListQueryController(ShoppingListQueryProcessor shoppingListQueryProcessor) {
        this.shoppingListQueryProcessor = shoppingListQueryProcessor;
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
}
