package school.listecourses.exercicelistedecourses.application.listeCourses.commands.delete;

import lombok.Getter;

@Getter
public class ListeCoursesDeleteCommand {
    private final Long id;

    public ListeCoursesDeleteCommand(Long id) {
        this.id = id;
    }
}
