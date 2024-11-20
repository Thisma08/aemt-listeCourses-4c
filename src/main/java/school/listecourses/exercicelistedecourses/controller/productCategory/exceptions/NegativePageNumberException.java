package school.listecourses.exercicelistedecourses.controller.productCategory.exceptions;

public class NegativePageNumberException extends RuntimeException {
    public NegativePageNumberException() {
        super("Page number must be positive.");
    }
}
