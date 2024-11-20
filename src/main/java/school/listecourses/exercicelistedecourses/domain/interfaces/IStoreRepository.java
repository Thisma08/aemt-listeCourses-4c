package school.listecourses.exercicelistedecourses.domain.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbStore;

public interface IStoreRepository extends JpaRepository<DbStore, Long> {
    boolean existsByName(String name);
}
