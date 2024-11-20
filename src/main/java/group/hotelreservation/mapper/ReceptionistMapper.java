package group.hotelreservation.mapper;

import group.hotelreservation.dao.entity.ReceptionistEntity;
import group.hotelreservation.dao.entity.ReservationEntity;
import group.hotelreservation.dto.receptionist.request.ReceptionistRequest;
import group.hotelreservation.dto.receptionist.response.ReceptionistResponse;
import group.hotelreservation.dto.reservation.response.ReservationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = RoomMapper.class)
public abstract class ReceptionistMapper {

    public abstract ReceptionistEntity mapToReceptionistEntity(ReceptionistRequest receptionistRequest);

    public abstract ReceptionistResponse mapToReceptionistResponse(ReceptionistEntity receptionistEntity);


}
