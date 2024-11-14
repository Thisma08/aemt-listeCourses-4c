package school.listecourses.exercicelistedecourses.application.listeCourses.commands.delete;

import lombok.Getter;

@Getter
public class ListeCoursesDeleteOutput {
    private final boolean success;
    private final String message;

    public ListeCoursesDeleteOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
