package school.listecourses.exercicelistedecourses.application.list.commands.update;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IListRepository;

@Service
public class ListUpdateHandler implements ICommandHandler<ListUpdateCommand, ListUpdateOutput> {
    private final IListRepository repository;

    public ListUpdateHandler(IListRepository repository) {
        this.repository = repository;
    }

    @Override
    public ListUpdateOutput handle(ListUpdateCommand command) {
        var listeCourses = repository.findById(command.getId());

        if(listeCourses.isPresent()) {
            var existingListeCourses = listeCourses.get();
            existingListeCourses.setName(command.getNewName());
            existingListeCourses.setDescription(command.getNewDescription());
            repository.save(existingListeCourses);

            return new ListUpdateOutput(true, "Shopping list updated successfully.");
        } else {
            return new ListUpdateOutput(false, "Shopping list not found.");
        }
    }
}
