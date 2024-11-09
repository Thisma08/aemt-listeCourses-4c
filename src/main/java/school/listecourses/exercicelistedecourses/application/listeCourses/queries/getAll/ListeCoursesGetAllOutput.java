package school.listecourses.exercicelistedecourses.application.listeCourses.queries.getAll;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListeCoursesGetAllOutput {
    public List<ListeCourses> listesCourses = new ArrayList<>();

    @Data
    public static class ListeCourses {
        private long id;
        private String name;
        private String description;
        private Date createdAt;
    }
}
