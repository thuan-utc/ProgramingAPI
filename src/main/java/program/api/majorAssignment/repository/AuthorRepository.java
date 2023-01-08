package program.api.majorAssignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import program.api.majorAssignment.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {
}
