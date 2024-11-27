package group.hotelreservation.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import group.hotelreservation.enums.HotelStars;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "hotel")
public class HotelEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(nullable = false)
    private String name;


    private String address;


    @Enumerated(EnumType.STRING)
    private HotelStars stars;


//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private List<RoomEntity> rooms;
//
//
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private List<ReceptionistEntity> receptionists;


}
