package tn.esprit.coexist.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.Carpooling;
import tn.esprit.coexist.entity.CarpoolingType;
import tn.esprit.coexist.repository.CarpoolingRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Aspect
@Slf4j
public class CarpoolingServiceImp implements CarpoolingService{
CarpoolingRepository carpoolingRepository;

    @Override
    public Carpooling addCarpooling(Carpooling carpooling) {
        if (carpooling.getCarpoolingType().equals(CarpoolingType.DAILY)) {
            carpooling.setDepartureTime(null);
            log.info("sssssssss");
        } else {
           carpooling.setDay(null);
           carpooling.setTime(null);
            log.info("aaaaaaaaa");
        }
        return carpoolingRepository.save(carpooling);
    }

    @Override
    public void delateCarpooling(Integer carpoolingId) {
        carpoolingRepository.deleteById(carpoolingId);
    }

    @Override
    public void updateCarpooling(Integer carpoolingId, Carpooling carpooling) {
       carpooling.setCarpoolingID(carpoolingId);
       carpoolingRepository.save(carpooling);
    }

    @Override
    public List<Carpooling> getAllCarpooling() {
        return carpoolingRepository.findAll();
    }

    @Override
    public Carpooling findCarpooling(Integer carpoolingId) {
        return carpoolingRepository.findById(carpoolingId).get();
    }


}
