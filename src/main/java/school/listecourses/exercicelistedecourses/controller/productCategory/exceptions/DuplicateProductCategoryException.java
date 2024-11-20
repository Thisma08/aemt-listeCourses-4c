package school.listecourses.exercicelistedecourses.controller.productCategory.exceptions;

public class DuplicateProductCategoryException extends RuntimeException {
    public DuplicateProductCategoryException(String name) {
        super("Product Category already exists with name : " + name);
    }
}