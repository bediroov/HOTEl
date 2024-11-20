//package group.hotelreservation.controller;
//
//import group.hotelreservation.dto.receptionist.request.ReceptionistRequest;
//import group.hotelreservation.dto.receptionist.response.ReceptionistResponse;
//import group.hotelreservation.dto.room.request.RoomRequest;
//import group.hotelreservation.dto.room.response.RoomResponse;
//import group.hotelreservation.service.ReceptionistService;
//import group.hotelreservation.service.RoomService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/receptionists")
//@RequiredArgsConstructor
//
//
//public class ReceptionistController {
//
//
//    private final ReceptionistService receptionistService;
//
//    @PostMapping
//    public ReceptionistResponse saveAllReceptionists(@RequestBody @Valid ReceptionistRequest receptionistRequest) {
//        return receptionistService.addReceptionists(receptionistRequest);
//    }
//
//    @GetMapping
//    public List<ReceptionistResponse> getAllReceptionists() {
//        return receptionistService.getAllReceptionists();
//    }
//
//
//    // bu get pathvariable ucun
//    @GetMapping("/{receptionistId}")
//    public ReceptionistResponse getReceptionistById(@PathVariable Long receptionistId) {
//        return receptionistService.getReceptionistById(receptionistId);
//    }
//
//
//
//    @PutMapping("/{roomId}")
//    public RoomResponse putRoom(@RequestBody RoomRequest roomRequest, @PathVariable Long roomId) {
//        return roomService.updateRoom(roomRequest, roomId);
//    }
//
//    @DeleteMapping("/{roomId}")
//    public void deleteRoom(@PathVariable Long roomId) {
//        roomService.deleteRoom(roomId);
//    }
//
//
//}
