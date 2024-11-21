package group.hotelreservation.controller;
import group.hotelreservation.dto.receptionist.request.ReceptionistRequest;
import group.hotelreservation.dto.receptionist.response.ReceptionistResponse;
import group.hotelreservation.service.ReceptionistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/receptionists")
@RequiredArgsConstructor


public class ReceptionistController {


    private final ReceptionistService receptionistService;


    @PostMapping
    public ReceptionistResponse saveAllReceptionists(@RequestBody @Valid ReceptionistRequest receptionistRequest) {
        return receptionistService.addReceptionists(receptionistRequest);
    }

    @GetMapping
    public List<ReceptionistResponse> getAllReceptionists() {
        return receptionistService.getAllReceptionists();
    }

    // bu get pathvariable ucun
    @GetMapping("/{receptionistId}")
    public ReceptionistResponse getReceptionistById(@PathVariable Long receptionistId) {
        return receptionistService.getReceptionistById(receptionistId);
    }



    @PutMapping("/{receptionistId}")
    public ReceptionistResponse putReceptionist(@RequestBody ReceptionistRequest receptionistRequest, @PathVariable Long receptionistId) {
        return receptionistService.updateReceptionist(receptionistRequest, receptionistId);
    }



    @DeleteMapping("/{receptionistId}")
    public void deleteRoom(@PathVariable Long receptionistId) {
        receptionistService.deleteReceptionist(receptionistId);
    }

}