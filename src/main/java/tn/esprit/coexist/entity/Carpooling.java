package tn.esprit.coexist.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Entity
@Data

public class Carpooling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carpoolingID;

    private LocalDateTime departureTime;
    private String longitudeDeparture;
    private String latitudeDestination;

    private String latitudeDeparture;
    private String longitudeDestination;



    private Integer availableSeats;
    private float costPerSeat;
    @Enumerated(EnumType.STRING)
    private Day day;
    LocalTime time;

    @Enumerated(EnumType.STRING)
    private CarpoolingType carpoolingType;
    private Long registrationNumber;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy ="carpooling",cascade = CascadeType.ALL)

    private List<Booking>bookings;
}
