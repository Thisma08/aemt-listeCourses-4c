package school.listecourses.exercicelistedecourses.controller.shoppingList.exceptions;

public class DuplicateShoppingListException extends RuntimeException {
    public DuplicateShoppingListException(String name) {
        super("Shopping list already exists with name : " + name);
    }
}