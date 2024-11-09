package school.listecourses.exercicelistedecourses.application.listeCourses.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.infrastructure.IListeCoursesRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbListeCourses;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListeCoursesGetAllHandler implements IQueryHandler<ListeCoursesGetAllQuery, ListeCoursesGetAllOutput>
{
    private final IListeCoursesRepository repository;
    private final ModelMapper modelMapper;

    public ListeCoursesGetAllHandler(IListeCoursesRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ListeCoursesGetAllOutput handle(ListeCoursesGetAllQuery query) {
        Page<DbListeCourses> dbListesCourses = repository.findAll(PageRequest.of(query.page, query.pageSize));
        ListeCoursesGetAllOutput output = new ListeCoursesGetAllOutput();

        for(DbListeCourses dbListeCourses : dbListesCourses) {
            ListeCoursesGetAllOutput.ListeCourses listeCourses = modelMapper.map(dbListeCourses, ListeCoursesGetAllOutput.ListeCourses.class);
            output.listesCourses.add(listeCourses);
        }
        return output;
    }
}
