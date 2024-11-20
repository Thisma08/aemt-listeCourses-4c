package school.listecourses.exercicelistedecourses.application.shoppingList.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.controller.shoppingList.exceptions.InvalidPageSizeException;
import school.listecourses.exercicelistedecourses.controller.shoppingList.exceptions.NegativePageNumberException;
import school.listecourses.exercicelistedecourses.domain.interfaces.IShoppingListRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbShoppingList;

@Service
public class ShoppingListGetAllHandler implements IQueryHandler<ShoppingListGetAllQuery, ShoppingListGetAllOutput>
{
    private final IShoppingListRepository repository;
    private final ModelMapper modelMapper;

    public ShoppingListGetAllHandler(IShoppingListRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ShoppingListGetAllOutput handle(ShoppingListGetAllQuery query) {
        if (query.page < 0) {
            throw new NegativePageNumberException();
        }
        if(query.pageSize != 10 && query.pageSize != 20) {
            throw new InvalidPageSizeException();
        }
        Page<DbShoppingList> dbList = repository.findAll(PageRequest.of(query.page, query.pageSize));
        ShoppingListGetAllOutput output = new ShoppingListGetAllOutput();

        for(DbShoppingList dbShoppingList : dbList) {
            ShoppingListGetAllOutput.ShoppingList shoppingList = modelMapper.map(dbShoppingList, ShoppingListGetAllOutput.ShoppingList.class);
            output.shoppingLists.add(shoppingList);
        }
        return output;
    }
}
