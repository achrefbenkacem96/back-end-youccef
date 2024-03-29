package tn.esprit.coexist.service.ColocationService.CollocationBooking;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import tn.esprit.coexist.entity.ColocationEntity.AnnoncementCollocation;
import tn.esprit.coexist.entity.ColocationEntity.CollocationBooking;
import tn.esprit.coexist.entity.ColocationEntity.StatusType;
import tn.esprit.coexist.entity.User;
import tn.esprit.coexist.repository.ColocationRepository.AnnoncementCollocationRepository;
import tn.esprit.coexist.repository.ColocationRepository.CollocationBookingRepository;
import tn.esprit.coexist.repository.UserRepository;
import tn.esprit.coexist.service.ICRUDService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingCollocationServiceImp implements ICRUDService<CollocationBooking,Integer>, tn.esprit.coexist.service.CollocationBooking.BookingCollocationService {
    @Autowired
    CollocationBookingRepository collocationBookingRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AnnoncementCollocationRepository annoncementCollocationRepository;
    @Autowired
    public JavaMailSender emailSender;


    @Override
    public List<CollocationBooking> findAll()  {
        System.out.println( collocationBookingRepository.findAll());
        return collocationBookingRepository.findAll();
    }

    @Override
    public CollocationBooking retrieveItem(Integer idItem) {
        return collocationBookingRepository.findById(idItem).get();
    }

    @Override
    public CollocationBooking add(CollocationBooking class1) {
        return null;
    }


    public CollocationBooking add(CollocationBooking booking, Integer userId) {
        // Récupérer l'utilisateur qui a ajouté le booking
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        AnnoncementCollocation annoncementCollocation = annoncementCollocationRepository.findById( booking.getAnnoncementCollocation().getAnnoncementCollocationId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        booking.setUser(user);
        booking.setAnnoncementCollocation(annoncementCollocation);
        CollocationBooking savedBooking = collocationBookingRepository.save(booking);

        AnnoncementCollocation annonce = savedBooking.getAnnoncementCollocation();
        User annonceOwner = annonce.getUser();
        String ownerEmail = annonceOwner.getEmail();
        sendEmail(ownerEmail);
        return savedBooking;
    }
    @Override
    public void delete(Integer idBooking) {
        collocationBookingRepository.deleteById(idBooking);

    }

    @Override
    public CollocationBooking update(Integer integer, CollocationBooking Classe1) {
        return null;
    }


    public List<CollocationBooking> updateCollocationBooking(Integer id, CollocationBooking newBooking) {
        CollocationBooking existingBooking = collocationBookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + id));

        StatusType oldStatusType = existingBooking.getStatusType();

        existingBooking.setStatusType(newBooking.getStatusType());

        CollocationBooking updatedBooking = collocationBookingRepository.save(existingBooking);

        if (!oldStatusType.equals(newBooking.getStatusType())) {
            User bookingUser = existingBooking.getUser();

            sendEmail2(bookingUser.getEmail());

        }
        return collocationBookingRepository.findAll();
    }
    public void sendEmail2(String email) {
        try {

            String htmlMsg =
                    " <h3>bonjour<h3>"+
                            "<h2>updated  " +
                            "<h3>cordianelemt<h3>" ;

            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://smtp-vuah.onrender.com/sendEmail?to="+email+"&subject=Update Booking&html="+htmlMsg;

            restTemplate.getForEntity(apiUrl, null, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public List<CollocationBooking> findBookingsByAnnouncementId(Integer announcementId) {
        return collocationBookingRepository.findByAnnoncementCollocationAnnoncementCollocationId(announcementId);
    }
    public List<CollocationBooking> findBookingsByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return collocationBookingRepository.findByUser(user);
    }

    public List<CollocationBooking> findBookingsByAnnId(Integer announcementId) {
        /*User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));*/
        AnnoncementCollocation annoncementCollocation = annoncementCollocationRepository.findById(announcementId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + announcementId));
        return collocationBookingRepository.findByAnnoncementCollocation( annoncementCollocation);
    }
    public void sendEmail(String email) {
        try {
            String htmlMsg =
                    " <h3>bonjour<h3>"+
                            "<h2>famaaaa hajaa  " +
                            "<h3>cordianelemt<h3>" ;

            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://smtp-vuah.onrender.com/sendEmail?to="+email+"&subject=Booking&html="+htmlMsg;

            restTemplate.getForEntity(apiUrl, null, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    }