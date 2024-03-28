package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;
    private String content;
    private  LocalDateTime dateTime;
    @ManyToOne
    private  Chatroom chatroom;


}
