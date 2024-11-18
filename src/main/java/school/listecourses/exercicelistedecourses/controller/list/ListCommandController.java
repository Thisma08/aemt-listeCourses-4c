package school.listecourses.exercicelistedecourses.controller.list;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.application.list.commands.ListCommandProcessor;
import school.listecourses.exercicelistedecourses.application.list.commands.create.ListCreateCommand;
import school.listecourses.exercicelistedecourses.application.list.commands.create.ListCreateOutput;
import school.listecourses.exercicelistedecourses.application.list.commands.delete.ListDeleteCommand;
import school.listecourses.exercicelistedecourses.application.list.commands.delete.ListDeleteOutput;
import school.listecourses.exercicelistedecourses.application.list.commands.update.ListUpdateCommand;
import school.listecourses.exercicelistedecourses.application.list.commands.update.ListUpdateOutput;
import school.listecourses.exercicelistedecourses.application.list.commands.update.ListUpdateRequest;

@RestController
@RequestMapping("/lists")
public class ListCommandController {
    private final ListCommandProcessor listCommandProcessor;

    public ListCommandController(ListCommandProcessor listCommandProcessor) {
        this.listCommandProcessor = listCommandProcessor;
    }

    @PutMapping("/{id}")
    public ListUpdateOutput updateListeCourses(@PathVariable Long id, @RequestBody ListUpdateRequest request) {
        ListUpdateCommand command = new ListUpdateCommand(id, request.getNewName(), request.getNewDescription());
        return listCommandProcessor.update(command);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201")
    public ListCreateOutput create(@RequestBody ListCreateCommand command) {
        return listCommandProcessor.create(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ListDeleteOutput> delete(@PathVariable Long id) {
        ListDeleteCommand command = new ListDeleteCommand(id);
        ListDeleteOutput output = listCommandProcessor.delete(command);

        if (output.isSuccess()) {
            return ResponseEntity.ok(output);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(output);
        }
    }
}
