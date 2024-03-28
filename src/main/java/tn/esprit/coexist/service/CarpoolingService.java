package tn.esprit.coexist.service;

import tn.esprit.coexist.entity.Carpooling;

import java.time.LocalDateTime;
import java.util.List;

public interface CarpoolingService {
    public Carpooling addCarpooling(Carpooling carpooling);
    public void delateCarpooling(Integer idCarpooling);
    public void updateCarpooling(Integer carpoolingId ,Carpooling carpooling);
    public List<Carpooling> getAllCarpooling();
    public Carpooling findCarpooling(Integer carpoolingId);

}
