package school.listecourses.exercicelistedecourses.application.listeCourses.commands.delete;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.infrastructure.IListeCoursesRepository;

@Service
public class ListeCoursesDeleteHandler implements ICommandHandler<ListeCoursesDeleteCommand, ListeCoursesDeleteOutput> {
    private final IListeCoursesRepository repository;

    public ListeCoursesDeleteHandler(IListeCoursesRepository repository) {
        this.repository = repository;
    }

    @Override
    public ListeCoursesDeleteOutput handle(ListeCoursesDeleteCommand command) {
        Long id = command.getId();
        if(!repository.existsById(id)) {
            return new ListeCoursesDeleteOutput(false, "List not found.");
        } else {
            repository.deleteById(id);
            return new ListeCoursesDeleteOutput(true, "List deleted successfully.");
        }
    }
}
