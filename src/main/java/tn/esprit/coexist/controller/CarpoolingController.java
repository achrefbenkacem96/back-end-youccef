package tn.esprit.coexist.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.coexist.entity.Booking;
import tn.esprit.coexist.entity.Carpooling;
import tn.esprit.coexist.service.BookingService;
import tn.esprit.coexist.service.CarpoolingService;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarpoolingController {
    CarpoolingService carpoolingService;
    BookingService bookingService;

@PostMapping("/addCarpooling")
public Carpooling addCarpooling(@RequestBody Carpooling carpooling)  {
   return carpoolingService.addCarpooling(carpooling);

}
@DeleteMapping("/delateCarpooling/{carpoolingId}")
public void delateCarpooling(@PathVariable Integer carpoolingId){
    carpoolingService.delateCarpooling(carpoolingId);

}
@PutMapping("/updateCarpooling/{carpoolingId}")
    public void updateCarpooling(@PathVariable Integer carpoolingId, @RequestBody Carpooling carpooling){
    carpoolingService.updateCarpooling(carpoolingId,carpooling);

    }
    @GetMapping("getAllCarpooling")
    public List<Carpooling> getAllCarpooling(){
return carpoolingService.getAllCarpooling();
    }
    @GetMapping("/findCarpooling/{carpoolingId}")
    public Carpooling findCarpooling(@PathVariable Integer carpoolingId){
    return carpoolingService.findCarpooling(carpoolingId);
    }

}
