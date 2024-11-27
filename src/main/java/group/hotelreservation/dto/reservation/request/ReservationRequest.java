package group.hotelreservation.dto.reservation.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReservationRequest {

    private String roomId;

    private Long customerId;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private double total_price;

    private boolean status;

    private String paymentMethod; // Ödəmə metodu (məsələn, "credit card")

}
