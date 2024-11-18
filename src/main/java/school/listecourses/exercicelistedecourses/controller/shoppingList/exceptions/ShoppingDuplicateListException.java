package school.listecourses.exercicelistedecourses.controller.shoppingList.exceptions;

public class ShoppingDuplicateListException extends RuntimeException {
    public ShoppingDuplicateListException(String name) {
        super("Course list already exists with name : " + name);
    }
}