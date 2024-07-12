package az.ramazan.questapp.requests;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
public class LikeCreateRequest {

    private Long id;
    private Long userId;
    private Long postId;
}
