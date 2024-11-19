package school.listecourses.exercicelistedecourses.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Store {
    private long id;
    public String name;
    public String logoUrl;
}
