package group.hotelreservation.scheduler;
import group.hotelreservation.service.NotficationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Slf4j
@Component
@RequiredArgsConstructor


public class NotficationScheduler {

    private final NotficationService notficationService;

    @Scheduled(cron = "0 45 15 * * ?")
    public void sendReservationReminders() {
        log.info("Reservation reminders service started...");
        notficationService.notifyCustomers();
        log.info("Reservation reminders service end...");
    }


}
