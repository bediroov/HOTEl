package group.hotelreservation.dto.room.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import group.hotelreservation.dao.entity.HotelEntity;
import group.hotelreservation.dao.entity.ReservationEntity;
import group.hotelreservation.dto.reservation.response.ReservationResponse;
import group.hotelreservation.enums.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoomResponse {


    private Long id;

    private RoomType roomType;  // meselen tek neferlik 2 neferlik olacagmi

    private Double price;

    private boolean status;

    private List<ReservationResponse> reservations;


}
