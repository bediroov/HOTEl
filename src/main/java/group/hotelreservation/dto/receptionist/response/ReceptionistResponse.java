package group.hotelreservation.dto.receptionist.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionistResponse {

    private Long id;
    private String name;
    private String surname;

    private String email;

    private String password;
}
