package school.listecourses.exercicelistedecourses.application.list.commands.delete;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IListRepository;

@Service
public class ListDeleteHandler implements ICommandHandler<ListDeleteCommand, ListDeleteOutput> {
    private final IListRepository repository;

    public ListDeleteHandler(IListRepository repository) {
        this.repository = repository;
    }

    @Override
    public ListDeleteOutput handle(ListDeleteCommand command) {
        Long id = command.getId();
        if(!repository.existsById(id)) {
            return new ListDeleteOutput(false, "List not found.");
        } else {
            repository.deleteById(id);
            return new ListDeleteOutput(true, "List deleted successfully.");
        }
    }
}
