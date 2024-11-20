package school.listecourses.exercicelistedecourses.controller.product.exceptions;

public class DuplicateProductException extends RuntimeException {
    public DuplicateProductException(String name) {
        super("Product already exists with name : " + name);
    }
}