package tn.esprit.coexist.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BookingID;

    private Integer nb;
    @ManyToOne
    private Carpooling carpooling;
    @ManyToOne (cascade = CascadeType.ALL)
    private User user;
    @OneToOne(mappedBy = "booking")
    private FeedBack feedBack;


}
