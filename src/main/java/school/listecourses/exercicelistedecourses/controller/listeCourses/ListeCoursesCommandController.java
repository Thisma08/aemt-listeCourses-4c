package school.listecourses.exercicelistedecourses.controller.listeCourses;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.ListeCoursesCommandProcessor;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.create.ListeCoursesCreateCommand;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.create.ListeCoursesCreateOutput;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.delete.ListeCoursesDeleteCommand;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.delete.ListeCoursesDeleteOutput;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.update.ListeCoursesUpdateCommand;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.update.ListeCoursesUpdateOutput;
import school.listecourses.exercicelistedecourses.application.listeCourses.commands.update.ListeCoursesUpdateRequest;

@RestController
@RequestMapping("/lists")
public class ListeCoursesCommandController {
    private final ListeCoursesCommandProcessor listeCoursesCommandProcessor;

    public ListeCoursesCommandController(ListeCoursesCommandProcessor listeCoursesCommandProcessor) {
        this.listeCoursesCommandProcessor = listeCoursesCommandProcessor;
    }

    @PutMapping("/{id}")
    public ListeCoursesUpdateOutput updateListeCourses(@PathVariable Long id, @RequestBody ListeCoursesUpdateRequest request) {
        ListeCoursesUpdateCommand command = new ListeCoursesUpdateCommand(id, request.getNewName(), request.getNewDescription());
        return listeCoursesCommandProcessor.update(command);
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ListeCoursesCreateOutput create(@RequestBody ListeCoursesCreateCommand command) {
        return listeCoursesCommandProcessor.create(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ListeCoursesDeleteOutput> delete(@PathVariable Long id) {
        ListeCoursesDeleteCommand command = new ListeCoursesDeleteCommand(id);
        ListeCoursesDeleteOutput output = listeCoursesCommandProcessor.delete(command);

        if (output.isSuccess()) {
            return ResponseEntity.ok(output);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(output);
        }
    }
}
