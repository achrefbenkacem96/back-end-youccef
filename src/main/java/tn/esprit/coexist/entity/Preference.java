package tn.esprit.coexist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
public class Preference{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer preferenceId;
    private LocalDateTime Departure_Time;
    private String longitude_Departure;
    private String latitude_Destination;

    private String latitude_Departure;
    private String longitude_Destination;



    private  int Available_Seats;
    private float CostPer_Seat;
    @Enumerated(EnumType.STRING)
    private Day day_;
    private  LocalTime time_;
    @Enumerated(EnumType.STRING)
    private CarpoolingType carpooling_Type;
    @OneToOne(mappedBy = "preference")
    @JsonIgnore
    private User user;

}
