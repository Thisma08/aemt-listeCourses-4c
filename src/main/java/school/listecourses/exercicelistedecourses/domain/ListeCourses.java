package school.listecourses.exercicelistedecourses.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ListeCourses {
    private long id;
    private String name;
    private String description;
    private Date createdAt;
}
