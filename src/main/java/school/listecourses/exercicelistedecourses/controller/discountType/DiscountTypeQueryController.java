package school.listecourses.exercicelistedecourses.controller.discountType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.listecourses.exercicelistedecourses.application.discountType.queries.DiscountTypeQueryProcessor;
import school.listecourses.exercicelistedecourses.application.discountType.queries.getAll.DiscountTypeGetAllOutput;
import school.listecourses.exercicelistedecourses.application.discountType.queries.getAll.DiscountTypeGetAllQuery;

@RestController
@RequestMapping("/discount-types")
public class DiscountTypeQueryController {
    private final DiscountTypeQueryProcessor discountTypeQueryProcessor;

    public DiscountTypeQueryController(DiscountTypeQueryProcessor discountTypeQueryProcessor) {
        this.discountTypeQueryProcessor = discountTypeQueryProcessor;
    }

    @GetMapping
    public Iterable<DiscountTypeGetAllOutput.DiscountType> getAll(DiscountTypeGetAllQuery query) {
        return discountTypeQueryProcessor.getAll(query).discountTypes;
    }
}
