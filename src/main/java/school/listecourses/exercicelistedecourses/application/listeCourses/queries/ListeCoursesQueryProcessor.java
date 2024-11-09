package school.listecourses.exercicelistedecourses.application.listeCourses.queries;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getAll.ListeCoursesGetAllHandler;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getAll.ListeCoursesGetAllOutput;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getAll.ListeCoursesGetAllQuery;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getById.ListeCoursesGetByIdHandler;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getById.ListeCoursesGetByIdOutput;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.searchByName.ListeCoursesSearchByNameHandler;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.searchByName.ListeCoursesSearchByNameOutput;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;

@Service
public class ListeCoursesQueryProcessor {
    private final IQueryHandler<ListeCoursesGetAllQuery, ListeCoursesGetAllOutput> listeCoursesGetAllHandler;
    private final IQueryHandler<Long, ListeCoursesGetByIdOutput> listeCoursesGetByIdHandler;
    private final IQueryHandler<String, ListeCoursesSearchByNameOutput> listeCoursesSearchByNameHandler;


    public ListeCoursesQueryProcessor(IQueryHandler<ListeCoursesGetAllQuery, ListeCoursesGetAllOutput> listeCoursesGetAllHandler, IQueryHandler<Long, ListeCoursesGetByIdOutput> listeCoursesGetByIdHandler, IQueryHandler<String, ListeCoursesSearchByNameOutput> listeCoursesSearchByNameHandler) {
        this.listeCoursesGetAllHandler = listeCoursesGetAllHandler;
        this.listeCoursesGetByIdHandler = listeCoursesGetByIdHandler;
        this.listeCoursesSearchByNameHandler = listeCoursesSearchByNameHandler;
    }

    public ListeCoursesGetAllOutput getAll(ListeCoursesGetAllQuery query) {
        return listeCoursesGetAllHandler.handle(query);
    }

    public ListeCoursesGetByIdOutput getById(long id) {
        return listeCoursesGetByIdHandler.handle(id);
    }

    public ListeCoursesSearchByNameOutput searchByTitle(String keyword) {
        return listeCoursesSearchByNameHandler.handle(keyword);
    }
}
