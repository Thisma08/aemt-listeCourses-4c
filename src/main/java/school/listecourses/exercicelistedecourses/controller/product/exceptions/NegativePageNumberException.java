package school.listecourses.exercicelistedecourses.controller.product.exceptions;

public class NegativePageNumberException extends RuntimeException {
    public NegativePageNumberException() {
        super("Page number must be positive.");
    }
}
