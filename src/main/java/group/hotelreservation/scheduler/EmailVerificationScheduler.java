//package group.hotelreservation.scheduler;
//import group.hotelreservation.service.EmailVerificationService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//
//
//public class EmailVerificationScheduler {
//
//    private final EmailVerificationService emailVerificationService;
//
//    @Scheduled(cron = "*/7 * * * * ?")
//    public void sendReservationReminders() {
//        log.info("Reservation reminders check started...");
//        emailVerificationService.notifyCustomersTwoDaysBefore();
//        log.info("Reservation reminders check completed.");
//    }
//
//}
