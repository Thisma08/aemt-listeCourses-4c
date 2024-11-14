package school.listecourses.exercicelistedecourses.application.listeCourses.commands.update;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.searchByName.ListeCoursesSearchByNameOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.application.utils.IEmptyOutputCommandHandler;
import school.listecourses.exercicelistedecourses.controller.listeCourses.exceptions.ListeCoursesNotFoundException;
import school.listecourses.exercicelistedecourses.domain.ListeCourses;
import school.listecourses.exercicelistedecourses.infrastructure.IListeCoursesRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbListeCourses;

@Service
public class ListeCoursesUpdateHandler implements ICommandHandler<ListeCoursesUpdateCommand, ListeCoursesUpdateOutput> {
    private final IListeCoursesRepository repository;

    public ListeCoursesUpdateHandler(IListeCoursesRepository repository) {
        this.repository = repository;
    }

    @Override
    public ListeCoursesUpdateOutput handle(ListeCoursesUpdateCommand command) {
        var listeCourses = repository.findById(command.getId());

        if(listeCourses.isPresent()) {
            var existingListeCourses = listeCourses.get();
            existingListeCourses.setName(command.getNewName());
            existingListeCourses.setDescription(command.getNewDescription());
            repository.save(existingListeCourses);

            return new ListeCoursesUpdateOutput(true, "Shopping list updated successfully.");
        } else {
            return new ListeCoursesUpdateOutput(false, "Shopping list not found.");
        }
    }
}
