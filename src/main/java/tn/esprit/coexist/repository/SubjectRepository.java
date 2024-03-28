package tn.esprit.coexist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.coexist.entity.Booking;
import tn.esprit.coexist.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {


}
