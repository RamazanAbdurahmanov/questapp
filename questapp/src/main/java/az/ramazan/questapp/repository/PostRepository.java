package az.ramazan.questapp.repository;

import az.ramazan.questapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Long> findTopByUserId(Long userId);

    List<Post> findByUserId(Long aLong);
}
