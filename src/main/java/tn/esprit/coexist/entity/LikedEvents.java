package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class LikedEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long IdEventLiked;
    private  Date likedAt;
    private  Boolean isLiked;


    @ManyToOne
    private Event event;

    @ManyToOne
    private User user;
}