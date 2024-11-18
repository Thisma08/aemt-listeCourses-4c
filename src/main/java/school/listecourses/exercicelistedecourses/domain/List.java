package school.listecourses.exercicelistedecourses.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class List {
    private long id;
    private String name;
    private String description;
    private Date createdAt;
}
