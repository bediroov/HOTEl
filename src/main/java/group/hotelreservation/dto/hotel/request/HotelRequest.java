package group.hotelreservation.dto.hotel.request;


import group.hotelreservation.dto.room.request.RoomRequest;
import group.hotelreservation.enums.HotelStars;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HotelRequest {


    @NotBlank(message = "name can not be empty")
    private String name;

    private String address;

//    @Enumerated(EnumType.STRING)
//    private HotelStars stars;
      private String stars;


//    private List<RoomRequest> rooms;
}
