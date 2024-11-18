package school.listecourses.exercicelistedecourses.application.shoppingList.queries.getAll;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingListGetAllOutput {
    public List<ShoppingList> shoppingLists = new ArrayList<>();

    @Data
    public static class ShoppingList {
        private long id;
        private String name;
        private String description;
        private Date createdAt;
    }
}
