package school.listecourses.exercicelistedecourses.application.discountType.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.discountType.commands.create.DiscountTypeCreateCommand;
import school.listecourses.exercicelistedecourses.application.discountType.commands.create.DiscountTypeCreateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class DiscountTypeCommandProcessor {
    private final ICommandHandler<DiscountTypeCreateCommand, DiscountTypeCreateOutput> createDiscountTypeHandler;


    public DiscountTypeCommandProcessor(ICommandHandler<DiscountTypeCreateCommand, DiscountTypeCreateOutput> createDiscountTypeHandler) {
        this.createDiscountTypeHandler = createDiscountTypeHandler;
    }

    public DiscountTypeCreateOutput create(DiscountTypeCreateCommand command) {
        return createDiscountTypeHandler.handle(command);
    }
}
