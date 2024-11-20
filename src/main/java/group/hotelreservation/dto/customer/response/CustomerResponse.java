package group.hotelreservation.dto.customer.response;
import group.hotelreservation.dto.reservation.response.ReservationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private Long id;

    private String name;

    private String surname;

    private Integer age;

    private String email;

    private String phonenumber;

    private List<ReservationResponse> reservations;



}
