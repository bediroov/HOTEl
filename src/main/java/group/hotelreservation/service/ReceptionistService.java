//package group.hotelreservation.service;
//
//import group.hotelreservation.dao.repository.RoomRepository;
//import group.hotelreservation.dto.receptionist.request.ReceptionistRequest;
//import group.hotelreservation.dto.receptionist.response.ReceptionistResponse;
//import group.hotelreservation.dto.room.request.RoomRequest;
//import group.hotelreservation.dto.room.response.RoomResponse;
//import group.hotelreservation.mapper.ReceptionistMapper;
//import group.hotelreservation.mapper.RoomMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//
//public class ReceptionistService {
//
//
//    private final ReceptionistService receptionistService;
//    private final ReceptionistMapper receptionistMapper;
//
//
//    public RoomResponse addRoomWithReservations(RoomRequest roomRequest) {
//        var roomEntity = roomMapper.mapToRoomEntity(roomRequest);
//
//        if (roomEntity.getReservations() != null) {
//            roomEntity.getReservations().forEach(reservation->reservation.setRoom(roomEntity));
//        }
//
//        roomRepository.save(roomEntity);
//        var response = roomMapper.mapToRoomResponse(roomEntity);
//        System.out.println("response:" + response);
//        return response;
//    }
//
//    public List<RoomResponse> getAllRooms() {
//        var roomEntityList = roomRepository.findAll();
//        return roomEntityList.stream().map(roomMapper::mapToRoomResponse).collect(Collectors.toList());
//    }
//
//    public RoomResponse getRoomById(Long roomId) {
//        var roomEntity = roomRepository.findById(roomId)
//                .orElseThrow(() -> new RuntimeException("Room not found"));
//        return roomMapper.mapToRoomResponse(roomEntity);
//    }
//
//    public RoomResponse updateRoom(RoomRequest roomRequest, Long roomId) {
//
//        var existRoom = roomRepository.findById(roomId)
//                .orElseThrow(() -> new RuntimeException("Room not Found"));
//
//        existRoom.setRoomType(roomRequest.getRoomType());
//        existRoom.setPrice(roomRequest.getPrice());
//        existRoom.setStatus(roomRequest.isStatus());
//
//        roomRepository.save(existRoom);
//        return roomMapper.mapToRoomResponse(existRoom);
//    }
//
//    public void deleteRoom(Long roomId) {
//        roomRepository.deleteById(roomId);
//
//    }
//
//    public ReceptionistResponse addReceptionists(ReceptionistRequest receptionistRequest) {
//    }
//
//    public List<ReceptionistResponse> getAllReceptionists() {
//    }
//
//    public ReceptionistResponse getReceptionistById(Long receptionistId) {
//    }
//}
