package school.listecourses.exercicelistedecourses.application.discountType.queries.getAll;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class DiscountTypeGetAllOutput {
    public List<DiscountType> discountTypes = new ArrayList<>();

    @Data
    public static class DiscountType {
        private long id;
        private String description;
        private String backgroundColor;
        private String textColor;
    }
}
