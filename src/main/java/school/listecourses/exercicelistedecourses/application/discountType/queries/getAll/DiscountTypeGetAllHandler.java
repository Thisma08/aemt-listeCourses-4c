package school.listecourses.exercicelistedecourses.application.discountType.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;
import school.listecourses.exercicelistedecourses.domain.interfaces.IDiscountTypeRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbDiscountType;

@Service
public class DiscountTypeGetAllHandler implements ICommandHandler<DiscountTypeGetAllQuery, DiscountTypeGetAllOutput> {
    private final IDiscountTypeRepository repository;
    private final ModelMapper modelMapper;

    public DiscountTypeGetAllHandler(IDiscountTypeRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DiscountTypeGetAllOutput handle(DiscountTypeGetAllQuery query) {
        Page<DbDiscountType> dbDiscountTypes = repository.findAll(PageRequest.of(query.page, query.pageSize));
        DiscountTypeGetAllOutput output = new DiscountTypeGetAllOutput();

        for(DbDiscountType dbDiscountType : dbDiscountTypes) {
            DiscountTypeGetAllOutput.DiscountType discountType = modelMapper.map(dbDiscountType, DiscountTypeGetAllOutput.DiscountType.class);
            output.discountTypes.add(discountType);
        }

        return output;
    }
}
