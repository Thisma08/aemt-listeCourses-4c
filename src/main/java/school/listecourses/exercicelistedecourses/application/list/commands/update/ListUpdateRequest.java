package school.listecourses.exercicelistedecourses.application.list.commands.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListUpdateRequest {
    private String newName;
    private String newDescription;
}
