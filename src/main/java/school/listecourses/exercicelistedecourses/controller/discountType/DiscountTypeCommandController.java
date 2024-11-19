package school.listecourses.exercicelistedecourses.controller.discountType;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import school.listecourses.exercicelistedecourses.application.discountType.commands.DiscountTypeCommandProcessor;
import school.listecourses.exercicelistedecourses.application.discountType.commands.create.DiscountTypeCreateCommand;
import school.listecourses.exercicelistedecourses.application.discountType.commands.create.DiscountTypeCreateOutput;
import school.listecourses.exercicelistedecourses.application.discountType.commands.update.DiscountTypeUpdateCommand;
import school.listecourses.exercicelistedecourses.application.discountType.commands.update.DiscountTypeUpdateOutput;
import school.listecourses.exercicelistedecourses.application.discountType.commands.update.DiscountTypeUpdateRequest;
import school.listecourses.exercicelistedecourses.application.store.commands.update.StoreUpdateCommand;
import school.listecourses.exercicelistedecourses.application.store.commands.update.StoreUpdateOutput;
import school.listecourses.exercicelistedecourses.application.store.commands.update.StoreUpdateRequest;

@RestController
@RequestMapping("/discount-types")
public class DiscountTypeCommandController {
    private final DiscountTypeCommandProcessor discountTypeCommandProcessor;

    public DiscountTypeCommandController(DiscountTypeCommandProcessor discountTypeCommandProcessor) {
        this.discountTypeCommandProcessor = discountTypeCommandProcessor;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201")
    public DiscountTypeCreateOutput create(@RequestBody DiscountTypeCreateCommand command) {
        return discountTypeCommandProcessor.create(command);
    }

    @PutMapping("/{id}")
    public DiscountTypeUpdateOutput update(@PathVariable long id, @RequestBody DiscountTypeUpdateRequest request) {
        DiscountTypeUpdateCommand command = new DiscountTypeUpdateCommand(id, request.getNewDescription(), request.getNewBackgroundColor(), request.getNewTextColor());
        return discountTypeCommandProcessor.update(command);
    }
}
