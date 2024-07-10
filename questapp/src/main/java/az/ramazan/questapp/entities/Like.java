package az.ramazan.questapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "p_like")
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private Long userId;
}
