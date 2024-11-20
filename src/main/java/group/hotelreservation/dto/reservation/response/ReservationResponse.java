package group.hotelreservation.dto.reservation.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReservationResponse {
    private Long id;
    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private double total_price;

    private boolean status;

    private String paymentMethod;


}
