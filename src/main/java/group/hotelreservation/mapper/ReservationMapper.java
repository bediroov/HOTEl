package group.hotelreservation.mapper;
import group.hotelreservation.dao.entity.ReservationEntity;
import group.hotelreservation.dto.reservation.request.ReservationRequest;
import group.hotelreservation.dto.reservation.response.ReservationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ReservationMapper {

    public abstract ReservationEntity mapToReservationEntity(ReservationRequest reservationRequest);

    public abstract ReservationResponse mapToReservationResponse(ReservationEntity reservationEntity);


}
