package school.listecourses.exercicelistedecourses.application.shoppingList.commands.update;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IShoppingListRepository;

@Service
public class ShoppingListUpdateHandler implements ICommandHandler<ShoppingListUpdateCommand, ShoppingListUpdateOutput> {
    private final IShoppingListRepository repository;

    public ShoppingListUpdateHandler(IShoppingListRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShoppingListUpdateOutput handle(ShoppingListUpdateCommand command) {
        var shoppingList = repository.findById(command.getId());

        if(shoppingList.isPresent()) {
            var existingShoppingList = shoppingList.get();
            existingShoppingList.setName(command.getNewName());
            existingShoppingList.setDescription(command.getNewDescription());
            repository.save(existingShoppingList);

            return new ShoppingListUpdateOutput(true, "Shopping list updated successfully.");
        } else {
            return new ShoppingListUpdateOutput(false, "Shopping list not found.");
        }
    }
}
