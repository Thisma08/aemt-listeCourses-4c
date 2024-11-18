package school.listecourses.exercicelistedecourses.application.list.commands.update;

import lombok.Getter;

@Getter
public class ListUpdateCommand {
    private final Long id;
    private final String newName;
    private final String newDescription;

    public ListUpdateCommand(Long id, String newName, String newDescription) {
        this.id = id;
        this.newName = newName;
        this.newDescription = newDescription;
    }
}
