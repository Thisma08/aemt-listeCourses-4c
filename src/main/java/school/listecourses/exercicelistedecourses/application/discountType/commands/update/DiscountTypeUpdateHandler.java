package school.listecourses.exercicelistedecourses.application.discountType.commands.update;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IDiscountTypeRepository;

@Service
public class DiscountTypeUpdateHandler implements ICommandHandler<DiscountTypeUpdateCommand, DiscountTypeUpdateOutput> {
    private final IDiscountTypeRepository repository;

    public DiscountTypeUpdateHandler(IDiscountTypeRepository repository) {
        this.repository = repository;
    }


    @Override
    public DiscountTypeUpdateOutput handle(DiscountTypeUpdateCommand command) {
        var discountType = repository.findById(command.getId());

        if(discountType.isPresent()) {
            var existingDiscountType = discountType.get();
            existingDiscountType.setDescription(command.getNewDescription());
            existingDiscountType.setBackgroundColor(command.getNewBackgroundColor());
            existingDiscountType.setTextColor(command.getNewTextColor());
            repository.save(existingDiscountType);

            return new DiscountTypeUpdateOutput(true, "Discount Type updated successfully");
        } else {
            return new DiscountTypeUpdateOutput(false, "Discount Type not found");
        }
    }
}
