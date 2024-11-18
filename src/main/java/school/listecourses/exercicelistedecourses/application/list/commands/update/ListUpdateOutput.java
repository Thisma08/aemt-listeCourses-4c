package school.listecourses.exercicelistedecourses.application.list.commands.update;

import lombok.Getter;

@Getter
public class ListUpdateOutput {
    private final boolean success;
    private final String message;

    public ListUpdateOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
