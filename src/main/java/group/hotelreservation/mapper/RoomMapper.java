package group.hotelreservation.mapper;
import group.hotelreservation.dao.entity.RoomEntity;
import group.hotelreservation.dto.room.request.RoomRequest;
import group.hotelreservation.dto.room.response.RoomResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring",uses = ReservationMapper.class)
public abstract class RoomMapper {

//    @Mapping(source = "reservations",target = "reservations")
    public abstract RoomEntity mapToRoomEntity(RoomRequest roomRequest);

    @Mapping(source = "reservations",target = "reservations")
    public abstract RoomResponse mapToRoomResponse(RoomEntity roomEntity);

}
