package school.listecourses.exercicelistedecourses.application.list.queries.searchByName;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListSearchByNameOutput {
    public List<ListSearchByNameOutput.ListeCourses> todos = new ArrayList<>();

    @Data
    public static class ListeCourses {
        private long id;
        private String name;
        private String description;
        private Date createdAt;
    }
}
