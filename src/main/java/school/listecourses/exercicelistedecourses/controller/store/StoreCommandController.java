package school.listecourses.exercicelistedecourses.controller.store;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.application.store.commands.StoreCommandProcessor;
import school.listecourses.exercicelistedecourses.application.store.commands.create.StoreCreateCommand;
import school.listecourses.exercicelistedecourses.application.store.commands.create.StoreCreateOutput;
import school.listecourses.exercicelistedecourses.application.store.commands.delete.StoreDeleteCommand;
import school.listecourses.exercicelistedecourses.application.store.commands.delete.StoreDeleteOutput;
import school.listecourses.exercicelistedecourses.application.store.commands.update.StoreUpdateCommand;
import school.listecourses.exercicelistedecourses.application.store.commands.update.StoreUpdateOutput;
import school.listecourses.exercicelistedecourses.application.store.commands.update.StoreUpdateRequest;

@RestController
@RequestMapping("/stores")
public class StoreCommandController {
    private final StoreCommandProcessor storeCommandProcessor;

    public StoreCommandController(StoreCommandProcessor storeCommandProcessor) {
        this.storeCommandProcessor = storeCommandProcessor;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201")
    public StoreCreateOutput create(@RequestBody StoreCreateCommand command) {
        return storeCommandProcessor.create(command);
    }

    @PutMapping("/{id}")
    public StoreUpdateOutput update(@PathVariable long id, @RequestBody StoreUpdateRequest request) {
        StoreUpdateCommand command = new StoreUpdateCommand(id, request.getNewName(), request.getNewLogoUrl());
        return storeCommandProcessor.update(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StoreDeleteOutput> delete(@PathVariable long id) {
        StoreDeleteCommand command = new StoreDeleteCommand(id);
        StoreDeleteOutput output = storeCommandProcessor.delete(command);

        if (output.isSuccess()) {
            return ResponseEntity.ok(output);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(output);
        }
    }
}
