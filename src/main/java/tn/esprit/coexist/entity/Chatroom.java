package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Chatroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer chatRoomId;
    private String receiver;
    private String sender;
    @ManyToMany(mappedBy = "chatrooms" , cascade = CascadeType.ALL)
    private List<User>users;
    @OneToMany(mappedBy = "chatroom" ,cascade = CascadeType.ALL)
    private List<Message>messages;



}
