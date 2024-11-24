package group.hotelreservation.service;
import group.hotelreservation.dao.entity.HotelEntity;
import group.hotelreservation.dao.entity.RoomEntity;
import group.hotelreservation.dao.repository.HotelRepository;
import group.hotelreservation.dao.repository.RoomRepository;
import group.hotelreservation.dto.room.request.RoomRequest;
import group.hotelreservation.dto.room.response.RoomResponse;
import group.hotelreservation.exceptions.NotFoundException;
import group.hotelreservation.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    private final HotelRepository hotelRepository;

    @Transactional
    public RoomResponse saveRoom(RoomRequest roomRequest) {

        HotelEntity hotel = hotelRepository.findById(roomRequest.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        RoomEntity room = roomMapper.mapToRoomEntity(roomRequest);
        room.setHotel(hotel);
        roomRepository.save(room);
        return roomMapper.mapToRoomResponse(room);

    }


    public List<RoomResponse> getAllRooms() {
        var roomEntityList = roomRepository.findAll();
        return roomEntityList.stream().map(roomMapper::mapToRoomResponse).collect(Collectors.toList());
    }


    public RoomResponse getRoomById(Long roomId) {
        var roomEntity = roomRepository.findById(roomId)
                .orElseThrow(() -> new NotFoundException("Room not found ","Room not found:" + roomId));
        return roomMapper.mapToRoomResponse(roomEntity);
    }


    public RoomResponse updateRoom(RoomRequest roomRequest, Long roomId) {

        var existRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not Found"));

        existRoom.setRoomType(roomRequest.getRoomType());
        existRoom.setPrice(roomRequest.getPrice());
        existRoom.setStatus(roomRequest.isStatus());

        roomRepository.save(existRoom);
        return roomMapper.mapToRoomResponse(existRoom);
    }

    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }

}
