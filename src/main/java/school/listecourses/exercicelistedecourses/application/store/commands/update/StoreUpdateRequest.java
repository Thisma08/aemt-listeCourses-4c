package school.listecourses.exercicelistedecourses.application.store.commands.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreUpdateRequest {
    private String newName;
    private String newLogoUrl;
}
