package az.ramazan.questapp.responses;

import az.ramazan.questapp.entities.Comment;

public class CommentResponse {
    private Long id;
    private Long userId;
    private String username;
    private String text;

    public CommentResponse(Comment entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.username = entity.getUser().getUsername();
        this.text = entity.getText();
    }
}
