package az.ramazan.questapp.repository;

import az.ramazan.questapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Object> findUserCommentsByPostId(List<Long> postIds);

    List<Comment> findByUserIdAndPostId(Long aLong, Long aLong1);

    List<Comment> findByUserId(Long aLong);

    List<Comment> findByPostId(Long aLong);
}
