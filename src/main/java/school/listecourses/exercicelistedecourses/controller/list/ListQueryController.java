package school.listecourses.exercicelistedecourses.controller.list;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.listecourses.exercicelistedecourses.application.list.queries.ListQueryProcessor;
import school.listecourses.exercicelistedecourses.application.list.queries.getAll.ListGetAllOutput;
import school.listecourses.exercicelistedecourses.application.list.queries.getAll.ListGetAllQuery;
import school.listecourses.exercicelistedecourses.application.list.queries.getById.ListGetByIdOutput;
import school.listecourses.exercicelistedecourses.application.list.queries.searchByName.ListSearchByNameOutput;

@RestController
@RequestMapping("/lists")
public class ListQueryController {
    private final ListQueryProcessor listQueryProcessor;

    public ListQueryController(ListQueryProcessor listQueryProcessor) {
        this.listQueryProcessor = listQueryProcessor;
    }

    @GetMapping
    public Iterable<ListGetAllOutput.ListeCourses> getAll(ListGetAllQuery query) {
        return listQueryProcessor.getAll(query).listesCourses;
    }

    @GetMapping(value = "/{id}")
    public ListGetByIdOutput getById(@PathVariable long id) {
        return listQueryProcessor.getById(id);
    }

    @GetMapping(value = "search/by-name/{name}")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400")
    })
    public ListSearchByNameOutput searchByName(@PathVariable() String name) {
        return listQueryProcessor.searchByName(name);
    }
}
