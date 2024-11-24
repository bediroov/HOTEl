package group.hotelreservation.exceptions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException {

    private String message;
    private String logMessage;

    public ValidationException(String message, String logMessage) {
        this.message = message;
        this.logMessage = logMessage;
    }
}

