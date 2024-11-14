package school.listecourses.exercicelistedecourses.application.listeCourses.commands.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
public class ListeCoursesUpdateCommand {
    private final Long id;
    private final String newName;
    private final String newDescription;

    public ListeCoursesUpdateCommand(Long id, String newName, String newDescription) {
        this.id = id;
        this.newName = newName;
        this.newDescription = newDescription;
    }
}
