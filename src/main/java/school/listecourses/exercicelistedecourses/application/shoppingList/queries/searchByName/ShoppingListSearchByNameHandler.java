package school.listecourses.exercicelistedecourses.application.shoppingList.queries.searchByName;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IShoppingListRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbShoppingList;

@Service
public class ShoppingListSearchByNameHandler implements IQueryHandler<String, ShoppingListSearchByNameOutput> {
    private final IShoppingListRepository repository;
    private final ModelMapper modelMapper;

    public ShoppingListSearchByNameHandler(IShoppingListRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ShoppingListSearchByNameOutput handle(String input) {
        Iterable<DbShoppingList> dbListesCourses = repository.findByNameContaining(input);
        ShoppingListSearchByNameOutput output = new ShoppingListSearchByNameOutput();

        for (DbShoppingList dbShoppingList : dbListesCourses) {
            ShoppingListSearchByNameOutput.ListeCourses listeCourses = modelMapper.map(dbShoppingList, ShoppingListSearchByNameOutput.ListeCourses.class);
            output.todos.add(listeCourses);
        }

        return output;
    }
}
