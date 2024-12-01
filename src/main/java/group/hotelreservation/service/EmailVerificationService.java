package group.hotelreservation.service;
import group.hotelreservation.dao.entity.ReservationEntity;
import group.hotelreservation.dao.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RequiredArgsConstructor
//@Slf4j
//@Service
//
//public class EmailVerificationService {
//
//
//    public final ReservationRepository reservationRepository;
//    public final EmailService emailService;
//
//    @Transactional
//    public void notifyCustomersTwoDaysBefore(){
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime start= now.plusDays(2).withHour(0).withMinute(0).withSecond(0);
//        LocalDateTime end= now.plusDays(2).withHour(23).withMinute(59).withSecond(59);
//
//        List<ReservationEntity> reservationEntities = reservationRepository.findReservationsTwodaysBefore(start,end);
//
//
//        for (ReservationEntity reservation : reservationEntities) {
//            String email = reservation.getCustomer().getEmail();
//            String subject = "Rezervasiyanıza 2 gün qaldı!";
//            String body = "Hörmətli " + reservation.getCustomer().getName() + ",<br>" +
//                    "Sizin rezervasiyanıza 2 gün qalıb. Ödənişi vaxtında etdiyinizə əmin olun.<br>" +
//                    "Rezervasiya Detalları:<br>" +
//                    "Giriş Tarixi: " + reservation.getCheckInDate() + "<br>" +
//                    "Çıxış Tarixi: " + reservation.getCheckOutDate() + "<br>" +
//                    "Ümumi Qiymət: " + reservation.getTotal_price() + " AZN<br>" +
//                    "<br>Təşəkkürlər,<br>Hotel Rezervasiya Komandası";
//
//            emailService.sendEmail(email, subject, body);
//        }
//    }
//
//
//
//}
