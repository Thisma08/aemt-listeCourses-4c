package school.listecourses.exercicelistedecourses.controller.listeCourses.exceptions;

public class DuplicateListeCoursesException extends RuntimeException {
    public DuplicateListeCoursesException(String name) {
        super("Course list already exists with name : " + name);
    }
}