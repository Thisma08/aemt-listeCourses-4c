package school.listecourses.exercicelistedecourses.application.store.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.store.commands.create.StoreCreateCommand;
import school.listecourses.exercicelistedecourses.application.store.commands.create.StoreCreateOutput;
import school.listecourses.exercicelistedecourses.application.store.commands.update.StoreUpdateCommand;
import school.listecourses.exercicelistedecourses.application.store.commands.update.StoreUpdateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class StoreCommandProcessor {
    private final ICommandHandler<StoreCreateCommand, StoreCreateOutput> createStoreHandler;
    private final ICommandHandler<StoreUpdateCommand, StoreUpdateOutput> updateStoreHandler;

    public StoreCommandProcessor(ICommandHandler<StoreCreateCommand, StoreCreateOutput> createStoreHandler, ICommandHandler<StoreUpdateCommand, StoreUpdateOutput> updateStoreHandler) {
        this.createStoreHandler = createStoreHandler;
        this.updateStoreHandler = updateStoreHandler;
    }

    public StoreCreateOutput create(StoreCreateCommand command) {
        return createStoreHandler.handle(command);
    }

    public StoreUpdateOutput update(StoreUpdateCommand command) {
        return updateStoreHandler.handle(command);
    }
}
