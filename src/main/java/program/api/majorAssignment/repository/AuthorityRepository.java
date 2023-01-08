package program.api.majorAssignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import program.api.majorAssignment.domain.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, String> {
    boolean existsById(String username);
}
