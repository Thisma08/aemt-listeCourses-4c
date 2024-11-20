package school.listecourses.exercicelistedecourses.domain.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbProductCategory;

public interface IProductCategoryRepository extends JpaRepository<DbProductCategory, Long> {
    boolean existsByName(String name);
}
