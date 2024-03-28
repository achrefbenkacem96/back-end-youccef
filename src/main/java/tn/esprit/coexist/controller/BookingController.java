package tn.esprit.coexist.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import tn.esprit.coexist.entity.Booking;
import tn.esprit.coexist.service.BookingService;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookingController {
    BookingService bookingService;
    @PostMapping("/addBooking/{carpoolingID}")

    public Booking addBooking(@RequestBody Booking booking,@PathVariable Integer carpoolingID){
        return bookingService.addBooking(booking,carpoolingID);
    }
    @DeleteMapping ("deleteBooking/{bookingId}")
    public void deleteBooking(@PathVariable Integer bookingId){
        bookingService.deleteBooking(bookingId);

    }
    @GetMapping("/getALLBooking")
    public List<Booking> getALLBooking(){
       return bookingService.getALLBooking();
    }
}


