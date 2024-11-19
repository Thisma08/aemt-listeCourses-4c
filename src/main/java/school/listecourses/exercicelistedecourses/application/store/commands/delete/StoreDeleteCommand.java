package school.listecourses.exercicelistedecourses.application.store.commands.delete;

import lombok.Getter;

@Getter
public class StoreDeleteCommand {
    private final long id;

    public StoreDeleteCommand(long id) {
        this.id = id;
    }
}
