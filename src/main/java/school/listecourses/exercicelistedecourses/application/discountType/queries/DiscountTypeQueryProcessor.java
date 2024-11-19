package school.listecourses.exercicelistedecourses.application.discountType.queries;

import org.springframework.stereotype.Service;
import school.listecourses.exercicelistedecourses.application.discountType.queries.getAll.DiscountTypeGetAllOutput;
import school.listecourses.exercicelistedecourses.application.discountType.queries.getAll.DiscountTypeGetAllQuery;
import school.listecourses.exercicelistedecourses.application.utils.ICommandHandler;

@Service
public class DiscountTypeQueryProcessor {
    private final ICommandHandler<DiscountTypeGetAllQuery, DiscountTypeGetAllOutput> discountTypeGetAllHandler;

    public DiscountTypeQueryProcessor(ICommandHandler<DiscountTypeGetAllQuery, DiscountTypeGetAllOutput> discountTypeGetAllHandler) {
        this.discountTypeGetAllHandler = discountTypeGetAllHandler;
    }

    public DiscountTypeGetAllOutput getAll(DiscountTypeGetAllQuery query) {
        return discountTypeGetAllHandler.handle(query);
    }
}
