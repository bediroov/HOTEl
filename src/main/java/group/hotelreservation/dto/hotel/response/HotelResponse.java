package group.hotelreservation.dto.hotel.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import group.hotelreservation.dao.entity.RoomEntity;
import group.hotelreservation.dto.room.response.RoomResponse;
import group.hotelreservation.enums.HotelStars;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HotelResponse {


    private Long id;

    private String name;

    private String address;

    @Enumerated(EnumType.STRING)
    private HotelStars stars;

    private List<RoomResponse> rooms;


}
