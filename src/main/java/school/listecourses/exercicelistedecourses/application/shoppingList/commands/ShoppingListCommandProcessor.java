package school.listecourses.exercicelistedecourses.application.shoppingList.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.create.ShoppingListCreateCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.create.ShoppingListCreateOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete.ShoppingListDeleteCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.delete.ShoppingListDeleteOutput;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateCommand;
import school.listecourses.exercicelistedecourses.application.shoppingList.commands.update.ShoppingListUpdateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class ShoppingListCommandProcessor {
    private final ICommandHandler<ShoppingListUpdateCommand, ShoppingListUpdateOutput> updateListeCoursesHandler;
    private final ICommandHandler<ShoppingListCreateCommand, ShoppingListCreateOutput> createListeCoursesHandler;
    private final ICommandHandler<ShoppingListDeleteCommand, ShoppingListDeleteOutput> deleteListeCoursesHandler;



    public ShoppingListCommandProcessor(ICommandHandler<ShoppingListUpdateCommand, ShoppingListUpdateOutput> updateListeCoursesHandler, ICommandHandler<ShoppingListCreateCommand, ShoppingListCreateOutput> createListeCoursesHandler, ICommandHandler<ShoppingListDeleteCommand, ShoppingListDeleteOutput> deleteListeCoursesHandler) {
        this.updateListeCoursesHandler = updateListeCoursesHandler;
        this.createListeCoursesHandler = createListeCoursesHandler;
        this.deleteListeCoursesHandler = deleteListeCoursesHandler;
    }

    public ShoppingListUpdateOutput update(ShoppingListUpdateCommand command) {
        return updateListeCoursesHandler.handle(command);
    }

    public ShoppingListCreateOutput create(ShoppingListCreateCommand command) {
        return createListeCoursesHandler.handle(command);
    }

    public ShoppingListDeleteOutput delete (ShoppingListDeleteCommand command) {
        return deleteListeCoursesHandler.handle(command);
    }
}
