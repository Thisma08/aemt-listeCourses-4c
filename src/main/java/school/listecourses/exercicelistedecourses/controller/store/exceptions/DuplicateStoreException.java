package school.listecourses.exercicelistedecourses.controller.store.exceptions;

public class DuplicateStoreException extends RuntimeException {
    public DuplicateStoreException(String name) {
        super("Store already exists with name : " + name);
    }
}