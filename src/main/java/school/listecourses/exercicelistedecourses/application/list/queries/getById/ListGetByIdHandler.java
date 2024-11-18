package school.listecourses.exercicelistedecourses.application.list.queries.getById;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.IQueryHandler;
import school.listecourses.exercicelistedecourses.controller.list.exceptions.ListNotFoundException;
import school.listecourses.exercicelistedecourses.domain.interfaces.IListRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbList;

@Service
public class ListGetByIdHandler implements IQueryHandler<Long, ListGetByIdOutput> {
    private final IListRepository repository;
    private final ModelMapper modelMapper;

    public ListGetByIdHandler(IListRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ListGetByIdOutput handle(Long id) {
        DbList dbList = repository.findById(id).orElseThrow(() -> new ListNotFoundException(id));

        return modelMapper.map(dbList, ListGetByIdOutput.class);
    }
}
