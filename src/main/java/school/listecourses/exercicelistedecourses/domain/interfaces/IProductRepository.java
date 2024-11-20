package school.listecourses.exercicelistedecourses.domain.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProduct;

public interface IProductRepository extends JpaRepository<DbProduct, Long> {
    boolean existsByName(String name);
}
