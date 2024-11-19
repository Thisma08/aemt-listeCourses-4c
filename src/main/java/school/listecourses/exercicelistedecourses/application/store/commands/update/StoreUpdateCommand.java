package school.listecourses.exercicelistedecourses.application.store.commands.update;

import lombok.Getter;

@Getter
public class StoreUpdateCommand {
    private final long id;
    private final String newName;
    private final String newLogoUrl;

    public StoreUpdateCommand(long id, String newName, String newLogoUrl) {
        this.id = id;
        this.newName = newName;
        this.newLogoUrl = newLogoUrl;
    }
}
