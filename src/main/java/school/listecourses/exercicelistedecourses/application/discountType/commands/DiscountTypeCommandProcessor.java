package school.listecourses.exercicelistedecourses.application.discountType.commands;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.discountType.commands.create.DiscountTypeCreateCommand;
import school.listecourses.exercicelistedecourses.application.discountType.commands.create.DiscountTypeCreateOutput;
import school.listecourses.exercicelistedecourses.application.discountType.commands.delete.DiscountTypeDeleteCommand;
import school.listecourses.exercicelistedecourses.application.discountType.commands.delete.DiscountTypeDeleteOutput;
import school.listecourses.exercicelistedecourses.application.discountType.commands.update.DiscountTypeUpdateCommand;
import school.listecourses.exercicelistedecourses.application.discountType.commands.update.DiscountTypeUpdateOutput;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class DiscountTypeCommandProcessor {
    private final ICommandHandler<DiscountTypeCreateCommand, DiscountTypeCreateOutput> createDiscountTypeHandler;
    private final ICommandHandler<DiscountTypeUpdateCommand, DiscountTypeUpdateOutput> updateDiscountTypeHandler;
    private final ICommandHandler<DiscountTypeDeleteCommand, DiscountTypeDeleteOutput> deleteDiscountTypeHandler;

    public DiscountTypeCommandProcessor(ICommandHandler<DiscountTypeCreateCommand, DiscountTypeCreateOutput> createDiscountTypeHandler, ICommandHandler<DiscountTypeUpdateCommand, DiscountTypeUpdateOutput> updateDiscountTypeHandler, ICommandHandler<DiscountTypeDeleteCommand, DiscountTypeDeleteOutput> deleteDiscountTypeHandler) {
        this.createDiscountTypeHandler = createDiscountTypeHandler;
        this.updateDiscountTypeHandler = updateDiscountTypeHandler;
        this.deleteDiscountTypeHandler = deleteDiscountTypeHandler;
    }

    public DiscountTypeCreateOutput create(DiscountTypeCreateCommand command) {
        return createDiscountTypeHandler.handle(command);
    }

    public DiscountTypeUpdateOutput update(DiscountTypeUpdateCommand command) {
        return updateDiscountTypeHandler.handle(command);
    }

    public DiscountTypeDeleteOutput delete(DiscountTypeDeleteCommand command) {
        return deleteDiscountTypeHandler.handle(command);
    }
}
