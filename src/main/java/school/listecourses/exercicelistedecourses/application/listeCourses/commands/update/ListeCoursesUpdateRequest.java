package school.listecourses.exercicelistedecourses.application.listeCourses.commands.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListeCoursesUpdateRequest {
    private String newName;
    private String newDescription;
}
