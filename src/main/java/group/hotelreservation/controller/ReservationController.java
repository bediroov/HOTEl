package group.hotelreservation.controller;
import group.hotelreservation.dto.reservation.request.ReservationRequest;
import group.hotelreservation.dto.reservation.response.ReservationResponse;
import group.hotelreservation.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor



public class ReservationController {

    private final ReservationService reservationService;


    @PostMapping("/v2")
    public ReservationResponse createReservation(@RequestBody @Valid ReservationRequest reservationRequest){
        return reservationService.createReservation(reservationRequest);
    }



    @GetMapping
    public List<ReservationResponse> getAllReservations() {
        return reservationService.getAllReservations();
    }

    // bu get pathvariable ucun
    @GetMapping("/{reservationId}")
    public ReservationResponse getReservation(@PathVariable Long reservationId) {
        return reservationService.getReservationById(reservationId);
    }


    @PutMapping("/{reservationId}")
    public ReservationResponse putReservation(@RequestBody ReservationRequest reservationRequest, @PathVariable Long reservationId) {
        return reservationService.updateReservation(reservationRequest, reservationId);
    }

    @DeleteMapping("/{reservationId}")
    public void deleteReservation(@PathVariable Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }


}
