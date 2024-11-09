package school.listecourses.exercicelistedecourses.controller.listeCourses.exceptions;

public class InvalidPageSizeException extends RuntimeException {
    public InvalidPageSizeException() {
        super("Page size must be either 10 or 20.");
    }
}
