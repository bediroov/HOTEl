package group.hotelreservation.scheduler;
import group.hotelreservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Slf4j
@Component
@RequiredArgsConstructor
@Configuration



public class ReservationMailScheduler {
    private final ReservationService reservationService;

    @Scheduled(cron = "*/7 * * * * ?")
    public void reservationSchedule(){
        log.info("Start reservationSchedule()");

        reservationService.sendMail();

        log.info("End reservationSchedule()");
    }

}
