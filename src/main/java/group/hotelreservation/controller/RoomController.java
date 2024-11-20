package group.hotelreservation.controller;
import group.hotelreservation.dto.reservation.request.ReservationRequest;
import group.hotelreservation.dto.reservation.response.ReservationResponse;
import group.hotelreservation.dto.room.request.RoomRequest;
import group.hotelreservation.dto.room.response.RoomResponse;
import group.hotelreservation.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor

public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public RoomResponse saveAllRooms(@RequestBody @Valid RoomRequest roomRequest) {
        return roomService.addRoomWithReservations(roomRequest);
    }

    @GetMapping
    public List<RoomResponse> getAllRooms() {
        return roomService.getAllRooms();
    }


    // bu get pathvariable ucun
    @GetMapping("/{roomId}")
    public RoomResponse getRoomById(@PathVariable Long roomId) {
        return roomService.getRoomById(roomId);
    }



    @PutMapping("/{roomId}")
    public RoomResponse putRoom(@RequestBody RoomRequest roomRequest, @PathVariable Long roomId) {
        return roomService.updateRoom(roomRequest, roomId);
    }

    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
    }



}
