package group.hotelreservation.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "hotel")
public class HotelEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String name;


    private String address;


//    @Enumerated(EnumType.ORDINAL)
//    private HotelStars stars;

    private String stars;

//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private List<RoomEntity> rooms;
//
//
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private List<ReceptionistEntity> receptionists;


}
