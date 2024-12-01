package group.hotelreservation.service;

import group.hotelreservation.dao.entity.ReservationEntity;
import group.hotelreservation.dao.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service

public class EmailVerificationService {


    public final ReservationRepository reservationRepository;
    public final EmailService emailService;

    public void notifyCustomers() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = now.plusMinutes(20).withMinute(0).withSecond(0);
        LocalDateTime end = now.plusMinutes(50).withMinute(59).withSecond(59);

        List<ReservationEntity> reservationEntities = reservationRepository.findAllByCheckInDateBetween(start, end);

        for (ReservationEntity reservation : reservationEntities) {
            String email = reservation.getCustomer().getEmail();
            String subject = "Rezervasiya Xatırlatması";
            String body = String.format(
                    "Salam %s ,Reservasiyaniza yarm saat qalb.Detallar:Check-in: %s, Check-out: %s.",
                    reservation.getCustomer().getName(),
                    reservation.getCheckInDate(),
                    reservation.getCheckOutDate()
            );
            emailService.sendEmail(email, subject, body);

        }


    }

}
