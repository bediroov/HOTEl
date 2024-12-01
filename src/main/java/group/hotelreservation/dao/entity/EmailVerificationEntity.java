package group.hotelreservation.dao.entity;
import group.hotelreservation.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "email")

public class EmailVerificationEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String email;
    private String verificationCode;
    private LocalDateTime issueDate;
    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;



}
