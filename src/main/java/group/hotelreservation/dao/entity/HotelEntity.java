package group.hotelreservation.dao.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import group.hotelreservation.enums.HotelStars;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class HotelEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;
    @Column(nullable = false)

    @Enumerated(EnumType.STRING)
    private HotelStars stars;

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<RoomEntity> rooms;


    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ReceptionistEntity> receptionists;

}
