package school.listecourses.exercicelistedecourses.application.listeCourses.commands.create;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.ListeCourses;
import school.listecourses.exercicelistedecourses.infrastructure.IListeCoursesRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbListeCourses;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class ListeCoursesCreateHandler implements ICommandHandler<ListeCoursesCreateCommand, ListeCoursesCreateOutput> {
    private final IListeCoursesRepository repository;
    private final ModelMapper modelMapper;

    public ListeCoursesCreateHandler(IListeCoursesRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ListeCoursesCreateOutput handle(ListeCoursesCreateCommand input) {
        ListeCourses listeCourses =new ListeCourses();
        listeCourses.setName(input.name);
        listeCourses.setDescription(input.description);
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        Date fixedDate = Date.from(currentDateTime.toInstant());
        listeCourses.setCreatedAt(fixedDate);

        DbListeCourses dbListeCourses = modelMapper.map(listeCourses, DbListeCourses.class);
        DbListeCourses dbListeCoursesCreated = repository.save(dbListeCourses);

        return modelMapper.map(dbListeCoursesCreated, ListeCoursesCreateOutput.class);
    }
}
