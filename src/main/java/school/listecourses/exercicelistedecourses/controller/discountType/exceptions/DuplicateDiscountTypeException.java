package school.listecourses.exercicelistedecourses.controller.discountType.exceptions;

public class DuplicateDiscountTypeException extends RuntimeException {
    public DuplicateDiscountTypeException(String description) {
        super("Discount Type already exists with description : " + description);
    }
}