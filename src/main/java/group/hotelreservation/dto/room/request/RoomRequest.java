package group.hotelreservation.dto.room.request;
import group.hotelreservation.dto.reservation.request.ReservationRequest;
import group.hotelreservation.enums.RoomType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class RoomRequest {

    private Long hotelId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;  // meselen tek neferlik 2 neferlik olacagmi

    private Double price;

    private boolean status;

    private List<ReservationRequest> reservations;

}
