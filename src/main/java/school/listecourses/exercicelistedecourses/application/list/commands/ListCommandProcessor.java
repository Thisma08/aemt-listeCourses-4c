package school.listecourses.exercicelistedecourses.application.list.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.list.commands.create.ListCreateCommand;
import school.listecourses.exercicelistedecourses.application.list.commands.create.ListCreateOutput;
import school.listecourses.exercicelistedecourses.application.list.commands.delete.ListDeleteCommand;
import school.listecourses.exercicelistedecourses.application.list.commands.delete.ListDeleteOutput;
import school.listecourses.exercicelistedecourses.application.list.commands.update.ListUpdateCommand;
import school.listecourses.exercicelistedecourses.application.list.commands.update.ListUpdateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class ListCommandProcessor {
    private final ICommandHandler<ListUpdateCommand, ListUpdateOutput> updateListeCoursesHandler;
    private final ICommandHandler<ListCreateCommand, ListCreateOutput> createListeCoursesHandler;
    private final ICommandHandler<ListDeleteCommand, ListDeleteOutput> deleteListeCoursesHandler;



    public ListCommandProcessor(ICommandHandler<ListUpdateCommand, ListUpdateOutput> updateListeCoursesHandler, ICommandHandler<ListCreateCommand, ListCreateOutput> createListeCoursesHandler, ICommandHandler<ListDeleteCommand, ListDeleteOutput> deleteListeCoursesHandler) {
        this.updateListeCoursesHandler = updateListeCoursesHandler;
        this.createListeCoursesHandler = createListeCoursesHandler;
        this.deleteListeCoursesHandler = deleteListeCoursesHandler;
    }

    public ListUpdateOutput update(ListUpdateCommand command) {
        return updateListeCoursesHandler.handle(command);
    }

    public ListCreateOutput create(ListCreateCommand command) {
        return createListeCoursesHandler.handle(command);
    }

    public ListDeleteOutput delete (ListDeleteCommand command) {
        return deleteListeCoursesHandler.handle(command);
    }
}
