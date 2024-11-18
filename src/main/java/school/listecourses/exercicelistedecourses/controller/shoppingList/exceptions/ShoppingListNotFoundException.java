package school.listecourses.exercicelistedecourses.controller.shoppingList.exceptions;

public class ShoppingListNotFoundException extends RuntimeException {
    public ShoppingListNotFoundException(long id) {
        super("ListeCourse with id " + id + " not found");
    }
}
