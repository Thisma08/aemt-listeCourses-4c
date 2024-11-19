package school.listecourses.exercicelistedecourses.domain.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProductList;
import school.listecourses.exercicelistedecourses.infrastructure.embeddables.ProductListId;

public interface IProductListRepository extends JpaRepository<DbProductList, ProductListId> {
}
