package school.listecourses.exercicelistedecourses.application.store.commands.delete;

import lombok.Getter;

@Getter
public class StoreDeleteOutput {
    private final boolean success;
    private final String message;

    public StoreDeleteOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
