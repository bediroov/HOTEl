package group.hotelreservation.mapper;
import group.hotelreservation.dao.entity.HotelEntity;
import group.hotelreservation.dto.hotel.request.HotelRequest;
import group.hotelreservation.dto.hotel.response.HotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring",uses = RoomMapper.class)


public abstract class HotelMapper {

    @Mapping(source = "rooms",target = "rooms")
    public abstract HotelEntity mapToHotelEntity(HotelRequest hotelRequest);

    @Mapping(source = "rooms",target = "rooms")
    public abstract HotelResponse mapToHotelResponse(HotelEntity hotelEntity);


}
