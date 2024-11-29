package group.hotelreservation.dao.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;



@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor



public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private Integer age;

    private String email;

    private String phonenumber;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ReservationEntity> reservations;



}
