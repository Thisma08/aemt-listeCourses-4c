package school.listecourses.exercicelistedecourses.application.store.commands.create;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.Store;
import school.listecourses.exercicelistedecourses.domain.interfaces.IStoreRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbStore;

@Service
public class StoreCreateHandler implements ICommandHandler<StoreCreateCommand, StoreCreateOutput> {
    private final IStoreRepository repository;
    private final ModelMapper modelMapper;

    public StoreCreateHandler(IStoreRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StoreCreateOutput handle(StoreCreateCommand command) {
        Store store = new Store();
        store.setName(command.name);
        store.setLogoUrl(command.logoUrl);

        DbStore dbStore = modelMapper.map(store, DbStore.class);
        DbStore dbStoreCreated = repository.save(dbStore);

        return modelMapper.map(dbStoreCreated, StoreCreateOutput.class);
    }
}
