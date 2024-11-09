package school.listecourses.exercicelistedecourses.application.listeCourses.queries.getById;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.controller.listeCourses.exceptions.ListeCoursesNotFoundException;
import school.listecourses.exercicelistedecourses.infrastructure.IListeCoursesRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbListeCourses;

@Service
public class ListeCoursesGetByIdHandler implements IQueryHandler<Long, ListeCoursesGetByIdOutput> {
    private final IListeCoursesRepository repository;
    private final ModelMapper modelMapper;

    public ListeCoursesGetByIdHandler(IListeCoursesRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ListeCoursesGetByIdOutput handle(Long id) {
        DbListeCourses dbListeCourses = repository.findById(id).orElseThrow(() -> new ListeCoursesNotFoundException(id));

        return modelMapper.map(dbListeCourses, ListeCoursesGetByIdOutput.class);
    }
}
