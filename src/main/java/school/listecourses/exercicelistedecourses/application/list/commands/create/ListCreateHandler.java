package school.listecourses.exercicelistedecourses.application.list.commands.create;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.List;
import school.listecourses.exercicelistedecourses.domain.interfaces.IListRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbList;

import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class ListCreateHandler implements ICommandHandler<ListCreateCommand, ListCreateOutput> {
    private final IListRepository repository;
    private final ModelMapper modelMapper;

    public ListCreateHandler(IListRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ListCreateOutput handle(ListCreateCommand input) {
        List list = new List();
        list.setName(input.name);
        list.setDescription(input.description);
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        Date fixedDate = Date.from(currentDateTime.toInstant());
        list.setCreatedAt(fixedDate);

        DbList dbList = modelMapper.map(list, DbList.class);
        DbList dbListCreated = repository.save(dbList);

        return modelMapper.map(dbListCreated, ListCreateOutput.class);
    }
}
