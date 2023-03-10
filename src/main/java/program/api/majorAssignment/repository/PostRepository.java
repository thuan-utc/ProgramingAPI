package program.api.majorAssignment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import program.api.majorAssignment.domain.Post;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    @Query(value = "Select p from Post p join Author a on p.author = a.username where a.email = ?1")
    List<Post> findPostsOfAuthorSearchByEmail(String email);

    @Query(value = "SELECT * FROM Post ORDER BY date desc limit 10", nativeQuery = true)
    List<Post> findTop10Lastest();
}
