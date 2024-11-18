package school.listecourses.exercicelistedecourses.application.shoppingList.commands.create;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.ShoppingList;
import school.listecourses.exercicelistedecourses.domain.interfaces.IShoppingListRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbShoppingList;

import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class ShoppingListCreateHandler implements ICommandHandler<ShoppingListCreateCommand, ShoppingListCreateOutput> {
    private final IShoppingListRepository repository;
    private final ModelMapper modelMapper;

    public ShoppingListCreateHandler(IShoppingListRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ShoppingListCreateOutput handle(ShoppingListCreateCommand input) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setName(input.name);
        shoppingList.setDescription(input.description);
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        Date fixedDate = Date.from(currentDateTime.toInstant());
        shoppingList.setCreatedAt(fixedDate);

        DbShoppingList dbShoppingList = modelMapper.map(shoppingList, DbShoppingList.class);
        DbShoppingList dbShoppingListCreated = repository.save(dbShoppingList);

        return modelMapper.map(dbShoppingListCreated, ShoppingListCreateOutput.class);
    }
}
