package school.listecourses.exercicelistedecourses.application.store.commands.update;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IStoreRepository;

@Service
public class StoreUpdateHandler implements ICommandHandler<StoreUpdateCommand, StoreUpdateOutput> {
    private final IStoreRepository repository;

    public StoreUpdateHandler(IStoreRepository repository) {
        this.repository = repository;
    }


    @Override
    public StoreUpdateOutput handle(StoreUpdateCommand command) {
        var store = repository.findById(command.getId());

        if(store.isPresent()) {
            var existingStore = store.get();
            existingStore.setName(command.getNewName());
            existingStore.setLogoUrl(command.getNewLogoUrl());
            repository.save(existingStore);

            return new StoreUpdateOutput(true, "Store updated successfully");
        } else {
            return new StoreUpdateOutput(false, "Store not found");
        }
    }
}
