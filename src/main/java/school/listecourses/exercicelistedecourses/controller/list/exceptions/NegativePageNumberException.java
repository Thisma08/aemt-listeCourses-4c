package school.listecourses.exercicelistedecourses.controller.list.exceptions;

public class NegativePageNumberException extends RuntimeException {
    public NegativePageNumberException() {
        super("Page number must be positive.");
    }
}
