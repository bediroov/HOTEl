package group.hotelreservation.dto.customer.request;
import group.hotelreservation.dto.reservation.request.ReservationRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

// bu request servere post put ucun isdifade olunacag

public class CustomerRequest {

    @NotBlank(message = "name can't be empty")
    private String name;

    @NotBlank(message = "surname can't be empty")
    private String surname;

//    @Min(18)
    private Integer age;

    @Email(message = "email must be written @signature")
    private String email;

    @NotBlank(message = "can't be empty")
    private String phonenumber;


//    private List<ReservationRequest> reservations;


}
