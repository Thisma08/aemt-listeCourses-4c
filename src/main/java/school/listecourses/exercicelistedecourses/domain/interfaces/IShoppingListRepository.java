package school.listecourses.exercicelistedecourses.domain.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbShoppingList;

public interface IShoppingListRepository extends JpaRepository<DbShoppingList, Long> {
    boolean existsByName(String name);
    boolean existsByNameAndIdIsNot(String name, long id);
    Iterable<DbShoppingList> findByNameContaining(String name);
}