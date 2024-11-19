package school.listecourses.exercicelistedecourses.application.store.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.store.commands.create.StoreCreateCommand;
import school.listecourses.exercicelistedecourses.application.store.commands.create.StoreCreateOutput;
import school.listecourses.exercicelistedecourses.application.store.commands.delete.StoreDeleteCommand;
import school.listecourses.exercicelistedecourses.application.store.commands.delete.StoreDeleteOutput;
import school.listecourses.exercicelistedecourses.application.store.commands.update.StoreUpdateCommand;
import school.listecourses.exercicelistedecourses.application.store.commands.update.StoreUpdateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class StoreCommandProcessor {
    private final ICommandHandler<StoreCreateCommand, StoreCreateOutput> createStoreHandler;
    private final ICommandHandler<StoreUpdateCommand, StoreUpdateOutput> updateStoreHandler;
    private final ICommandHandler<StoreDeleteCommand, StoreDeleteOutput> deleteStoreHandler;


    public StoreCommandProcessor(ICommandHandler<StoreCreateCommand, StoreCreateOutput> createStoreHandler, ICommandHandler<StoreUpdateCommand, StoreUpdateOutput> updateStoreHandler, ICommandHandler<StoreDeleteCommand, StoreDeleteOutput> deleteStoreHandler) {
        this.createStoreHandler = createStoreHandler;
        this.updateStoreHandler = updateStoreHandler;
        this.deleteStoreHandler = deleteStoreHandler;
    }

    public StoreCreateOutput create(StoreCreateCommand command) {
        return createStoreHandler.handle(command);
    }

    public StoreUpdateOutput update(StoreUpdateCommand command) {
        return updateStoreHandler.handle(command);
    }

    public StoreDeleteOutput delete(StoreDeleteCommand command) {
        return deleteStoreHandler.handle(command);
    }
}
