package school.listecourses.exercicelistedecourses.application.shoppingList.queries;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.getAll.ShoppingListGetAllOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.getAll.ShoppingListGetAllQuery;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.getById.ShoppingListGetByIdOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.queries.searchByName.ShoppingListSearchByNameOutput;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;

@Service
public class ShoppingListQueryProcessor {
    private final IQueryHandler<ShoppingListGetAllQuery, ShoppingListGetAllOutput> shoppingListGetAllHandler;
    private final IQueryHandler<Long, ShoppingListGetByIdOutput> shoppingListGetByIdHandler;
    private final IQueryHandler<String, ShoppingListSearchByNameOutput> shoppingListSearchByNameHandler;


    public ShoppingListQueryProcessor(IQueryHandler<ShoppingListGetAllQuery, ShoppingListGetAllOutput> shoppingListGetAllHandler, IQueryHandler<Long, ShoppingListGetByIdOutput> shoppingListGetByIdHandler, IQueryHandler<String, ShoppingListSearchByNameOutput> shoppingListSearchByNameHandler) {
        this.shoppingListGetAllHandler = shoppingListGetAllHandler;
        this.shoppingListGetByIdHandler = shoppingListGetByIdHandler;
        this.shoppingListSearchByNameHandler = shoppingListSearchByNameHandler;
    }

    public ShoppingListGetAllOutput getAll(ShoppingListGetAllQuery query) {
        return shoppingListGetAllHandler.handle(query);
    }

    public ShoppingListGetByIdOutput getById(long id) {
        return shoppingListGetByIdHandler.handle(id);
    }

    public ShoppingListSearchByNameOutput searchByName(String keyword) {
        return shoppingListSearchByNameHandler.handle(keyword);
    }
}
