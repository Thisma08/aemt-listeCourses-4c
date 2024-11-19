package school.listecourses.exercicelistedecourses.application.store.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.store.commands.create.StoreCreateCommand;
import school.listecourses.exercicelistedecourses.application.store.commands.create.StoreCreateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class StoreCommandProcessor {
    private final ICommandHandler<StoreCreateCommand, StoreCreateOutput> createStoreHandler;

    public StoreCommandProcessor(ICommandHandler<StoreCreateCommand, StoreCreateOutput> createStoreHandler) {
        this.createStoreHandler = createStoreHandler;
    }

    public StoreCreateOutput create(StoreCreateCommand command) {
        return createStoreHandler.handle(command);
    }
}
