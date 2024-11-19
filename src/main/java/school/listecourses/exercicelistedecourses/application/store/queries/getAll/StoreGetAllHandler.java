package school.listecourses.exercicelistedecourses.application.store.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IStoreRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbStore;

@Service
public class StoreGetAllHandler implements IQueryHandler<StoreGetAllQuery, StoreGetAllOutput> {
    private final IStoreRepository repository;
    private final ModelMapper modelMapper;

    public StoreGetAllHandler(IStoreRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StoreGetAllOutput handle(StoreGetAllQuery query) {
        Page<DbStore> dbStores = repository.findAll(PageRequest.of(query.page, query.pageSize));
        StoreGetAllOutput output = new StoreGetAllOutput();

        for(DbStore dbStore : dbStores) {
            StoreGetAllOutput.Store store = modelMapper.map(dbStore, StoreGetAllOutput.Store.class);
            output.stores.add(store);
        }

        return output;
    }
}
