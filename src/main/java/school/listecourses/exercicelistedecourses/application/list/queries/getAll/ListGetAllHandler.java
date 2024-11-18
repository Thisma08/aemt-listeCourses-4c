package school.listecourses.exercicelistedecourses.application.list.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IListRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbList;

@Service
public class ListGetAllHandler implements IQueryHandler<ListGetAllQuery, ListGetAllOutput>
{
    private final IListRepository repository;
    private final ModelMapper modelMapper;

    public ListGetAllHandler(IListRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ListGetAllOutput handle(ListGetAllQuery query) {
        Page<DbList> dbListesCourses = repository.findAll(PageRequest.of(query.page, query.pageSize));
        ListGetAllOutput output = new ListGetAllOutput();

        for(DbList dbList : dbListesCourses) {
            ListGetAllOutput.ListeCourses listeCourses = modelMapper.map(dbList, ListGetAllOutput.ListeCourses.class);
            output.listesCourses.add(listeCourses);
        }
        return output;
    }
}
