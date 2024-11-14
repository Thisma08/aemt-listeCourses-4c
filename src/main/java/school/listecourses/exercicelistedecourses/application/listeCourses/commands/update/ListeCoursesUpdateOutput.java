package school.listecourses.exercicelistedecourses.application.listeCourses.commands.update;

import lombok.Getter;

@Getter
public class ListeCoursesUpdateOutput {
    private final boolean success;
    private final String message;

    public ListeCoursesUpdateOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
