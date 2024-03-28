package tn.esprit.coexist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.coexist.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int eventId;
    String eventName;
    String eventDescription;
    LocalDateTime eventDate;
    String eventLocation;
    String images;


    @ManyToOne
     private User user;


   @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LikedEvents> likedEventsList;

    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Evaluation>evaluations;
}
