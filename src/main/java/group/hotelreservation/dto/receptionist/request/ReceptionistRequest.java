package group.hotelreservation.dto.receptionist.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReceptionistRequest {

    @NotNull
    private Long hotelId;

    private String name;
    private String surname;

    private String email;

    private String password;

}
