package tn.esprit.coexist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EventBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer bookingEventId;
    @Enumerated(EnumType.STRING)
    TypeEventBookingStatus typeEventBookingStatus;

    @ManyToOne
    private Event event;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;




}
