package school.listecourses.exercicelistedecourses.application.listeCourses.queries;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getAll.ListeCoursesGetAllHandler;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getAll.ListeCoursesGetAllOutput;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getAll.ListeCoursesGetAllQuery;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getById.ListeCoursesGetByIdHandler;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getById.ListeCoursesGetByIdOutput;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;

@Service
public class ListeCoursesQueryProcessor {
    private final IQueryHandler<ListeCoursesGetAllQuery, ListeCoursesGetAllOutput> listeCoursesGetAllHandler;
    private final IQueryHandler<Long, ListeCoursesGetByIdOutput> listeCoursesGetByIdHandler;

    public ListeCoursesQueryProcessor(IQueryHandler<ListeCoursesGetAllQuery, ListeCoursesGetAllOutput> listeCoursesGetAllHandler, IQueryHandler<Long, ListeCoursesGetByIdOutput> listeCoursesGetByIdHandler) {
        this.listeCoursesGetAllHandler = listeCoursesGetAllHandler;
        this.listeCoursesGetByIdHandler = listeCoursesGetByIdHandler;
    }

    public ListeCoursesGetAllOutput getAll(ListeCoursesGetAllQuery query) {
        return listeCoursesGetAllHandler.handle(query);
    }

    public ListeCoursesGetByIdOutput getById(long id) {
        return listeCoursesGetByIdHandler.handle(id);
    }
}
