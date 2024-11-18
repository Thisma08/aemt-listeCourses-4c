package school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IShoppingListRepository;

@Service
public class ShoppingListDeleteHandler implements ICommandHandler<ShoppingListDeleteCommand, ShoppingListDeleteOutput> {
    private final IShoppingListRepository repository;

    public ShoppingListDeleteHandler(IShoppingListRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShoppingListDeleteOutput handle(ShoppingListDeleteCommand command) {
        Long id = command.getId();
        if(!repository.existsById(id)) {
            return new ShoppingListDeleteOutput(false, "List not found.");
        } else {
            repository.deleteById(id);
            return new ShoppingListDeleteOutput(true, "List deleted successfully.");
        }
    }
}
