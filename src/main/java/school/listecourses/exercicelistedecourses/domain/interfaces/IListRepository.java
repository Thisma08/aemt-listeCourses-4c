package school.listecourses.exercicelistedecourses.domain.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import school.listecourses.exercicelistedecourses.infrastructure.dbentities.DbList;

public interface IListRepository extends JpaRepository<DbList, Long> {
    boolean existsByName(String name);
    boolean existsByNameAndIdIsNot(String name, long id);
    Iterable<DbList> findByNameContaining(String name);
}