package group.hotelreservation.controller;
import group.hotelreservation.dto.exception.NotFoundDto;
import group.hotelreservation.dto.exception.ValidationExceptionDto;
import group.hotelreservation.exceptions.NotFoundException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleValidations(MethodArgumentNotValidException ex) {

        HashMap<String, String> errorList = new HashMap<>();
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        errors.forEach((e) -> {
            errorList.put(e.getField(), e.getDefaultMessage());
        });
        return errorList;

    }


        @ExceptionHandler(NotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public NotFoundDto handleNotFound(NotFoundException exception) {
            log.error(exception.getLogMessage());
            return new NotFoundDto(exception.getMessage());
        }


        @ExceptionHandler(ValidationException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ValidationExceptionDto handleValidation(ValidationExceptionDto exception) {
            log.error(exception.getMessage());
            return new ValidationExceptionDto(exception.getMessage());
        }


}
