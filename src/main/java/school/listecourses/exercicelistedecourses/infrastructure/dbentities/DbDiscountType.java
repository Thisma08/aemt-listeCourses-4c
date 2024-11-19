package school.listecourses.exercicelistedecourses.infrastructure.dbentities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "discount_types")
@Data
@NoArgsConstructor
public class DbDiscountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @Column(name="background_color")
    private String backgroundColor;
    @Column(name="text_color")
    private String textColor;
}
