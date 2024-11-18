package school.listecourses.exercicelistedecourses.application.list.queries.searchByName;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IListRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbList;

@Service
public class ListSearchByNameHandler implements IQueryHandler<String, ListSearchByNameOutput> {
    private final IListRepository repository;
    private final ModelMapper modelMapper;

    public ListSearchByNameHandler(IListRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ListSearchByNameOutput handle(String input) {
        Iterable<DbList> dbListesCourses = repository.findByNameContaining(input);
        ListSearchByNameOutput output = new ListSearchByNameOutput();

        for (DbList dbList : dbListesCourses) {
            ListSearchByNameOutput.ListeCourses listeCourses = modelMapper.map(dbList, ListSearchByNameOutput.ListeCourses.class);
            output.todos.add(listeCourses);
        }

        return output;
    }
}
