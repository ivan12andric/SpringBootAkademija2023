package hr.kingict.akademija2023.springbootakademija2023.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalControllerExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<String> handleException(MethodArgumentNotValidException exception){

        String errorMessage = exception.getAllErrors()
                .stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n\n"));

        return ResponseEntity
                .badRequest()
                .body(errorMessage);
    }
}
