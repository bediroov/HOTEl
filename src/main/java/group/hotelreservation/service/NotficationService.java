package group.hotelreservation.service;
import group.hotelreservation.dao.entity.ReservationEntity;
import group.hotelreservation.dao.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service

public class NotficationService {

    public final ReservationRepository reservationRepository;
    public final EmailService emailService;

    public void notifyCustomers() {
        LocalDate today = LocalDate.now().plusDays(0);
        List<ReservationEntity> todayReservation = reservationRepository.findReservationsForToday(today);

        for (ReservationEntity reservation : todayReservation) {
            System.out.println(reservation.getId());
            String email = reservation.getCustomer().getEmail();
            String subject = "Rezervasiya Xatırlatması";
            String body = String.format(
                    "Salam %s , Salam Reside Reservasiyaniz  .Detallar:Check-in: %s, Check-out: %s.",
                    reservation.getCustomer().getName(),
                    reservation.getCheckInDate(),
                    reservation.getCheckOutDate()
            );
            emailService.sendEmail(email, subject, body);

        }


    }

//    public void notifyCustomers() {
//        emailService.sendEmail("mahammad.code@gmail.com",
//                "TEST_EMAIL",
//                "Reservation notfication !!!");
//    }
}
