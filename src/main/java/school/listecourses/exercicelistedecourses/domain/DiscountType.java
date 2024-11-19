package school.listecourses.exercicelistedecourses.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiscountType {
    private long id;
    private String description;
    private String backgroundColor;
    private String textColor;
}
