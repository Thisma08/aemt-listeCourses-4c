package school.listecourses.exercicelistedecourses.controller.list.exceptions;

public class DuplicateListException extends RuntimeException {
    public DuplicateListException(String name) {
        super("Course list already exists with name : " + name);
    }
}