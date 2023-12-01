package med.voll.api.model.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratamentoDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity TratadorDeErros404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity TratadorDeErros400() {
        return ResponseEntity.badRequest().build();
    }
}
