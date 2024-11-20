package school.listecourses.exercicelistedecourses.application.discountType.commands.create;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.controller.discountType.exceptions.DuplicateDiscountTypeException;
import school.listecourses.exercicelistedecourses.domain.DiscountType;
import school.listecourses.exercicelistedecourses.domain.interfaces.IDiscountTypeRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbDiscountType;

@Service
public class DiscountTypeCreateHandler implements ICommandHandler<DiscountTypeCreateCommand, DiscountTypeCreateOutput> {
    private final IDiscountTypeRepository repository;
    private final ModelMapper modelMapper;

    public DiscountTypeCreateHandler(IDiscountTypeRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DiscountTypeCreateOutput handle(DiscountTypeCreateCommand command) {
        if(repository.existsByDescription(command.getDescription())) {
            throw new DuplicateDiscountTypeException(command.getDescription());
        } else {
            DiscountType discountType = new DiscountType();
            discountType.setDescription(command.description);
            discountType.setBackgroundColor(command.backgroundColor);
            discountType.setTextColor(command.textColor);

            DbDiscountType dbDiscountType = modelMapper.map(discountType, DbDiscountType.class);
            DbDiscountType dbDiscountTypeCreated = repository.save(dbDiscountType);

            return modelMapper.map(dbDiscountTypeCreated, DiscountTypeCreateOutput.class);
        }
    }
}
