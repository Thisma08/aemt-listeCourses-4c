package school.listecourses.exercicelistedecourses.application.listeCourses.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.create.ListeCoursesCreateCommand;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.create.ListeCoursesCreateOutput;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.delete.ListeCoursesDeleteCommand;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.delete.ListeCoursesDeleteOutput;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.update.ListeCoursesUpdateCommand;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.update.ListeCoursesUpdateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class ListeCoursesCommandProcessor {
    private final ICommandHandler<ListeCoursesUpdateCommand, ListeCoursesUpdateOutput> updateListeCoursesHandler;
    private final ICommandHandler<ListeCoursesCreateCommand, ListeCoursesCreateOutput> createListeCoursesHandler;
    private final ICommandHandler<ListeCoursesDeleteCommand, ListeCoursesDeleteOutput> deleteListeCoursesHandler;



    public ListeCoursesCommandProcessor(ICommandHandler<ListeCoursesUpdateCommand, ListeCoursesUpdateOutput> updateListeCoursesHandler, ICommandHandler<ListeCoursesCreateCommand, ListeCoursesCreateOutput> createListeCoursesHandler, ICommandHandler<ListeCoursesDeleteCommand, ListeCoursesDeleteOutput> deleteListeCoursesHandler) {
        this.updateListeCoursesHandler = updateListeCoursesHandler;
        this.createListeCoursesHandler = createListeCoursesHandler;
        this.deleteListeCoursesHandler = deleteListeCoursesHandler;
    }

    public ListeCoursesUpdateOutput update(ListeCoursesUpdateCommand command) {
        return updateListeCoursesHandler.handle(command);
    }

    public ListeCoursesCreateOutput create(ListeCoursesCreateCommand command) {
        return createListeCoursesHandler.handle(command);
    }

    public ListeCoursesDeleteOutput delete (ListeCoursesDeleteCommand command) {
        return deleteListeCoursesHandler.handle(command);
    }
}
