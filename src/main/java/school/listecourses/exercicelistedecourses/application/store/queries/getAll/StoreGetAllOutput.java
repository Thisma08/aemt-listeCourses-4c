package school.listecourses.exercicelistedecourses.application.store.queries.getAll;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class StoreGetAllOutput {
    public List<Store> stores = new ArrayList<>();

    @Data
    public static class Store {
        private long id;
        private String name;
        private String logoUrl;
    }
}
