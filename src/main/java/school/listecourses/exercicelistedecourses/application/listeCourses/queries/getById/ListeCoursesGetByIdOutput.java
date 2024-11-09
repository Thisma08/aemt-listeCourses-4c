package school.listecourses.exercicelistedecourses.application.listeCourses.queries.getById;

import lombok.Data;

import java.util.Date;

@Data
public class ListeCoursesGetByIdOutput {
    private long id;
    private String name;
    private String description;
    private Date createdAt;
}
