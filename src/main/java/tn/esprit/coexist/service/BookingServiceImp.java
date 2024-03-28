package tn.esprit.coexist.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.Booking;
import tn.esprit.coexist.entity.Carpooling;
import tn.esprit.coexist.repository.BookingRepository;
import tn.esprit.coexist.repository.CarpoolingRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImp implements BookingService{
CarpoolingRepository carpoolingRepository;
BookingRepository bookingRepository;

    @Override
    public Booking addBooking(Booking booking, Integer carpoolingID) {
        Carpooling carpooling = carpoolingRepository.findById(carpoolingID).orElseThrow(() -> new IllegalArgumentException("Invalid carpooling ID"));
 Integer nb=booking.getNb();
        if (carpooling.getAvailableSeats() <= 0) {
            throw new IllegalStateException("No available seats for this carpooling");
        }

        // Decrease the number of available seats
        if(carpooling.getAvailableSeats() - nb>0){
        int updatedAvailableSeats = carpooling.getAvailableSeats() - nb;
        carpooling.setAvailableSeats(updatedAvailableSeats);
        carpoolingRepository.save(carpooling);}

        // Assign the carpooling to the booking
        booking.setCarpooling(carpooling);
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Integer bookingId) {
        bookingRepository.deleteById(bookingId);


    }

    @Override
    public List<Booking> getALLBooking() {
        return bookingRepository.findAll();
    }
}



