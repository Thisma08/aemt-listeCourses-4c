package school.listecourses.exercicelistedecourses.application.store.commands.delete;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IStoreRepository;

@Service
public class StoreDeleteHandler implements ICommandHandler<StoreDeleteCommand, StoreDeleteOutput> {
    private final IStoreRepository repository;

    public StoreDeleteHandler(IStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public StoreDeleteOutput handle(StoreDeleteCommand command) {
        long id = command.getId();
        if(!repository.existsById(id)) {
            return new StoreDeleteOutput(false, "Store not found");
        } else {
            repository.deleteById(id);
            return new StoreDeleteOutput(true, "Store deleted successfully");
        }
    }
}
