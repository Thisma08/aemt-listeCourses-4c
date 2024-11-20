package school.listecourses.exercicelistedecourses.domain.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbDiscountType;

public interface IDiscountTypeRepository extends JpaRepository<DbDiscountType, Long> {
    boolean existsByDescription(String description);
}
