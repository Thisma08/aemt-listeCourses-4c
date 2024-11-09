package school.listecourses.exercicelistedecourses.application.listeCourses.queries.searchByName;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.infrastructure.IListeCoursesRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbListeCourses;

@Service
public class ListeCoursesSearchByNameHandler implements IQueryHandler<String, ListeCoursesSearchByNameOutput> {
    private final IListeCoursesRepository repository;
    private final ModelMapper modelMapper;

    public ListeCoursesSearchByNameHandler(IListeCoursesRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ListeCoursesSearchByNameOutput handle(String input) {
        Iterable<DbListeCourses> dbListesCourses = repository.findByNameContaining(input);
        ListeCoursesSearchByNameOutput output = new ListeCoursesSearchByNameOutput();

        for (DbListeCourses dbListeCourses : dbListesCourses) {
            ListeCoursesSearchByNameOutput.ListeCourses listeCourses = modelMapper.map(dbListeCourses, ListeCoursesSearchByNameOutput.ListeCourses.class);
            output.todos.add(listeCourses);
        }

        return output;
    }
}
