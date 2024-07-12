package az.ramazan.questapp.responses;

import az.ramazan.questapp.entities.Like;
import lombok.Data;

@Data
public class LikeResponse {
  private   Long id;
    private  Long userId;
    private Long postId;

    public LikeResponse(Like entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.postId = entity.getPost().getId();
    }
}
