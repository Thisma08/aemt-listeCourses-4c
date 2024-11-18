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
        var listeCourses = repository.findById(command.getId());

        if(listeCourses.isPresent()) {
            var existingListeCourses = listeCourses.get();
            existingListeCourses.setName(command.getNewName());
            existingListeCourses.setDescription(command.getNewDescription());
            repository.save(existingListeCourses);

            return new ShoppingListUpdateOutput(true, "Shopping list updated successfully.");
        } else {
            return new ShoppingListUpdateOutput(false, "Shopping list not found.");
        }
    }
}
