package school.listecourses.exercicelistedecourses.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.listecourses.exercicelistedecourses.domain.ListeCourses;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbListeCourses;

public interface IListeCoursesRepository extends JpaRepository<DbListeCourses, Long> {
    boolean existsByName(String name);
    boolean existsByNameAndIdIsNot(String name, long id);
    Iterable<DbListeCourses> findByNameContaining(String name);
}