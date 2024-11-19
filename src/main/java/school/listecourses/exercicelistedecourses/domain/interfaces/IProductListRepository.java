package school.listecourses.exercicelistedecourses.domain.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProductList;
import school.listecourses.exercicelistedecourses.infrastructure.embeddables.ProductListId;

import java.util.List;

public interface IProductListRepository extends JpaRepository<DbProductList, ProductListId> {
    @Query("SELECT p FROM DbProductList p WHERE p.id.listId = :listId")
    List<DbProductList> findByListId(Long listId);
}
