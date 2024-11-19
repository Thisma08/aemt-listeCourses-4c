package school.listecourses.exercicelistedecourses.controller.store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.listecourses.exercicelistedecourses.application.store.queries.StoreQueryProcessor;
import school.listecourses.exercicelistedecourses.application.store.queries.getAll.StoreGetAllOutput;
import school.listecourses.exercicelistedecourses.application.store.queries.getAll.StoreGetAllQuery;

@RestController
@RequestMapping("/stores")
public class StoreQueryController {
    private final StoreQueryProcessor storeQueryProcessor;

    public StoreQueryController(StoreQueryProcessor storeQueryProcessor) {
        this.storeQueryProcessor = storeQueryProcessor;
    }

    @GetMapping
    public Iterable<StoreGetAllOutput.Store> getAll(StoreGetAllQuery query) {
        return storeQueryProcessor.getAll(query).stores;
    }
}
