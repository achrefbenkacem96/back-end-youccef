package tn.esprit.coexist.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.Booking;

import java.util.List;


public interface BookingService {
  public Booking addBooking(Booking booking, Integer carpoolingID);
  public void deleteBooking(Integer bookingId);
  public List<Booking> getALLBooking();

}
