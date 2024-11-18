package school.listecourses.exercicelistedecourses.application.list.queries.getById;

import lombok.Data;

import java.util.Date;

@Data
public class ListGetByIdOutput {
    private long id;
    private String name;
    private String description;
    private Date createdAt;
}
