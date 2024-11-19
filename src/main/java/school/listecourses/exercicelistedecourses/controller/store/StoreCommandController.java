package school.listecourses.exercicelistedecourses.controller.store;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.application.store.commands.StoreCommandProcessor;
import school.listecourses.exercicelistedecourses.application.store.commands.create.StoreCreateCommand;
import school.listecourses.exercicelistedecourses.application.store.commands.create.StoreCreateOutput;

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
}
