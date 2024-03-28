package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class React {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer reactId;
    private  boolean isLaked;
    private  Date timestampp;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private  User user;


}
