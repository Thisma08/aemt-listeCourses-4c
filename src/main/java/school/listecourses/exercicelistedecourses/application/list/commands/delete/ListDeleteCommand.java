package school.listecourses.exercicelistedecourses.application.list.commands.delete;

import lombok.Getter;

@Getter
public class ListDeleteCommand {
    private final Long id;

    public ListDeleteCommand(Long id) {
        this.id = id;
    }
}
