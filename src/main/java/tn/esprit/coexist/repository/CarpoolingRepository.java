package tn.esprit.coexist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.coexist.entity.Carpooling;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CarpoolingRepository  extends JpaRepository<Carpooling,Integer> {
    List<Carpooling> findByDepartureTime(LocalDateTime departureTime);
}
