package school.listecourses.exercicelistedecourses.application.list.commands.delete;

import lombok.Getter;

@Getter
public class ListDeleteOutput {
    private final boolean success;
    private final String message;

    public ListDeleteOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
