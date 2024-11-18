package school.listecourses.exercicelistedecourses.application.shoppingList.queries.searchByName;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingListSearchByNameOutput {
    public List<ShoppingListSearchByNameOutput.ListeCourses> todos = new ArrayList<>();

    @Data
    public static class ListeCourses {
        private long id;
        private String name;
        private String description;
        private Date createdAt;
    }
}
