package school.listecourses.exercicelistedecourses.controller.shoppingList.exceptions;

public class NegativePageNumberException extends RuntimeException {
    public NegativePageNumberException() {
        super("Page number must be positive.");
    }
}
