package school.listecourses.exercicelistedecourses.application.discountType.commands.delete;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IDiscountTypeRepository;

@Service
public class DiscountTypeDeleteHandler implements ICommandHandler<DiscountTypeDeleteCommand, DiscountTypeDeleteOutput> {
    private final IDiscountTypeRepository repository;

    public DiscountTypeDeleteHandler(IDiscountTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiscountTypeDeleteOutput handle(DiscountTypeDeleteCommand command) {
        long id = command.getId();
        if(!repository.existsById(id)) {
            return new DiscountTypeDeleteOutput(false, "Discount type not found");
        } else {
            repository.deleteById(id);
            return new DiscountTypeDeleteOutput(true, "Discount type deleted successfully");
        }
    }
}
