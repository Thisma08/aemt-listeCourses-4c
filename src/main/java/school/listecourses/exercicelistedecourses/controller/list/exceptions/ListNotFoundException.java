package school.listecourses.exercicelistedecourses.controller.list.exceptions;

public class ListNotFoundException extends RuntimeException {
    public ListNotFoundException(long id) {
        super("ListeCourse with id " + id + " not found");
    }
}
