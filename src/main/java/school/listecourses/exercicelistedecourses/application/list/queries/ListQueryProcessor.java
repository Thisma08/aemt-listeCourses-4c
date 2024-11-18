package school.listecourses.exercicelistedecourses.application.list.queries;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.list.queries.getAll.ListGetAllOutput;
import school.listecourses.exercicelistedecourses.application.list.queries.getAll.ListGetAllQuery;
import school.listecourses.exercicelistedecourses.application.list.queries.getById.ListGetByIdOutput;
import school.listecourses.exercicelistedecourses.application.list.queries.searchByName.ListSearchByNameOutput;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;

@Service
public class ListQueryProcessor {
    private final IQueryHandler<ListGetAllQuery, ListGetAllOutput> listeCoursesGetAllHandler;
    private final IQueryHandler<Long, ListGetByIdOutput> listeCoursesGetByIdHandler;
    private final IQueryHandler<String, ListSearchByNameOutput> listeCoursesSearchByNameHandler;


    public ListQueryProcessor(IQueryHandler<ListGetAllQuery, ListGetAllOutput> listeCoursesGetAllHandler, IQueryHandler<Long, ListGetByIdOutput> listeCoursesGetByIdHandler, IQueryHandler<String, ListSearchByNameOutput> listeCoursesSearchByNameHandler) {
        this.listeCoursesGetAllHandler = listeCoursesGetAllHandler;
        this.listeCoursesGetByIdHandler = listeCoursesGetByIdHandler;
        this.listeCoursesSearchByNameHandler = listeCoursesSearchByNameHandler;
    }

    public ListGetAllOutput getAll(ListGetAllQuery query) {
        return listeCoursesGetAllHandler.handle(query);
    }

    public ListGetByIdOutput getById(long id) {
        return listeCoursesGetByIdHandler.handle(id);
    }

    public ListSearchByNameOutput searchByName(String keyword) {
        return listeCoursesSearchByNameHandler.handle(keyword);
    }
}
