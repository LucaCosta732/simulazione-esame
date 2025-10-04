package it.lucacosta.corsi.exception;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", e.getMessage());
        body.put("error", e.getClass().getName());
        body.put("timestamp", System.currentTimeMillis());
        body.put("path", e.getStackTrace()[0].getClassName());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(exception = CorsoNonTrovatoException.class)
    public ResponseEntity<Object> handleCorsoNonTrovatoException(CorsoNonTrovatoException e) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", e.getMessage());
        body.put("error", e.getClass().getName());
        body.put("timestamp", System.currentTimeMillis());
        body.put("path", e.getStackTrace()[0].getClassName());
        body.put("status", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(exception = PostoNonDisponibileException.class)
    public ResponseEntity<Object> handlePostoNonDisponibileException(PostoNonDisponibileException e) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", e.getMessage());
        body.put("error", e.getClass().getName());
        body.put("timestamp", System.currentTimeMillis());
        body.put("path", e.getStackTrace()[0].getClassName());
        body.put("status", HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException e) {

        Map<String, Object> body = new HashMap<>();

        List<String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage()) 
                .collect(Collectors.toList());

        body.put("message", errors);
        body.put("error", e.getClass().getName());
        body.put("timestamp", System.currentTimeMillis());
        body.put("path", e.getStackTrace()[0].getClassName());
        body.put("status", HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
