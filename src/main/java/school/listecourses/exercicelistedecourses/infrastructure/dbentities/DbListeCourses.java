package school.listecourses.exercicelistedecourses.infrastructure.dbentities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "lists")
@Data
@NoArgsConstructor
public class DbListeCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Column(name = "created_at")
    private Date createdAt;
}
