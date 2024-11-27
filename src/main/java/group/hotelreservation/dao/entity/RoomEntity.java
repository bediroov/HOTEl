package group.hotelreservation.dao.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import group.hotelreservation.enums.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;  // meselen tek neferlik 2 neferlik olacagmi

    private Double price;

    private boolean status;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ReservationEntity> reservations;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    @JsonManagedReference
    private HotelEntity hotel;



}
