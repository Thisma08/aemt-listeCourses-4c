package school.listecourses.exercicelistedecourses.application.shoppingList.queries.getById;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.controller.shoppingList.exceptions.ShoppingListNotFoundException;
import school.listecourses.exercicelistedecourses.domain.interfaces.IShoppingListRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbShoppingList;

@Service
public class ShoppingListGetByIdHandler implements IQueryHandler<Long, ShoppingListGetByIdOutput> {
    private final IShoppingListRepository repository;
    private final ModelMapper modelMapper;

    public ShoppingListGetByIdHandler(IShoppingListRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ShoppingListGetByIdOutput handle(Long id) {
        DbShoppingList dbShoppingList = repository.findById(id).orElseThrow(() -> new ShoppingListNotFoundException(id));

        return modelMapper.map(dbShoppingList, ShoppingListGetByIdOutput.class);
    }
}
