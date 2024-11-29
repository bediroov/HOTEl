package group.hotelreservation.dao.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "receptionists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ReceptionistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    @JsonManagedReference
    private HotelEntity hotel;


}
