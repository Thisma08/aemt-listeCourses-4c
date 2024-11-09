package school.listecourses.exercicelistedecourses.controller.listeCourses.exceptions;

public class ListeCoursesNotFoundException extends RuntimeException {
    public ListeCoursesNotFoundException(long id) {
        super("ListeCourse with id " + id + " not found");
    }
}
