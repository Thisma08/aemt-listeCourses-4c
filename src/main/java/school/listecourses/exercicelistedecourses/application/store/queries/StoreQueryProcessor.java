package school.listecourses.exercicelistedecourses.application.store.queries;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.store.queries.getAll.StoreGetAllOutput;
import school.listecourses.exercicelistedecourses.application.store.queries.getAll.StoreGetAllQuery;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;

@Service
public class StoreQueryProcessor {
    private final IQueryHandler<StoreGetAllQuery, StoreGetAllOutput> storeGetAllHandler;

    public StoreQueryProcessor(IQueryHandler<StoreGetAllQuery, StoreGetAllOutput> storeGetAllHandler) {
        this.storeGetAllHandler = storeGetAllHandler;
    }

    public StoreGetAllOutput getAll(StoreGetAllQuery query) {
        return storeGetAllHandler.handle(query);
    }
}
