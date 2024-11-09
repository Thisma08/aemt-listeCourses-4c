package school.listecourses.exercicelistedecourses.controller.listeCourses;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.ListeCoursesQueryProcessor;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getAll.ListeCoursesGetAllOutput;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getAll.ListeCoursesGetAllQuery;
import school.listecourses.exercicelistedecourses.application.listeCourses.queries.getById.ListeCoursesGetByIdOutput;

@RestController
@RequestMapping("/lists")
public class ListeCoursesQueryController {
    private final ListeCoursesQueryProcessor listeCoursesQueryProcessor;

    public ListeCoursesQueryController(ListeCoursesQueryProcessor listeCoursesQueryProcessor) {
        this.listeCoursesQueryProcessor = listeCoursesQueryProcessor;
    }

    @GetMapping
    public Iterable<ListeCoursesGetAllOutput.ListeCourses> getAll(ListeCoursesGetAllQuery query) {
        return listeCoursesQueryProcessor.getAll(query).listesCourses;
    }

    @GetMapping(value = "/{id}")
    public ListeCoursesGetByIdOutput getById(@PathVariable long id) {
        return listeCoursesQueryProcessor.getById(id);
    }
}
