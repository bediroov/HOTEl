package group.hotelreservation.dto.room.request;
import group.hotelreservation.enums.RoomType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class RoomRequest {

    @NotNull
    @Column(name = "hotel_id")
    private String hotelId;

    @Column(name = "room_type" , nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;  // meselen tek neferlik 2 neferlik olacagmi

    private Double price;

    private boolean status;

//    private List<ReservationRequest> reservations;

}
