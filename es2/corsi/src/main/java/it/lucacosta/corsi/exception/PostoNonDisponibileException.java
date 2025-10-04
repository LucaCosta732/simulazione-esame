package it.lucacosta.corsi.exception;


public class PostoNonDisponibileException extends RuntimeException {

    public PostoNonDisponibileException(String message) {
        super(message);
    }

    public PostoNonDisponibileException(String message, Throwable cause) {
        super(message, cause);
    }
}
