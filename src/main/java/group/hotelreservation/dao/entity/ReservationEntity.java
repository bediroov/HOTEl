package group.hotelreservation.dao.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private double total_price;
    private boolean status;

    private String paymentMethod; // Ödəmə metodu (məsələn, "credit card")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    @JsonManagedReference
    private RoomEntity room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private CustomerEntity customer;


}
