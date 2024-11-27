package group.hotelreservation.dto.room.response;

import group.hotelreservation.dto.reservation.response.ReservationResponse;
import group.hotelreservation.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoomResponse {


    private String  id;

    private RoomType roomType;  // meselen tek neferlik 2 neferlik olacagmi

    private Double price;

    private boolean status;

    private List<ReservationResponse> reservations;



}
