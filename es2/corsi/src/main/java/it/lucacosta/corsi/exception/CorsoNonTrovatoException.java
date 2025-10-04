package it.lucacosta.corsi.exception;

public class CorsoNonTrovatoException extends RuntimeException {

    public CorsoNonTrovatoException(String message) {
        super(message);
    }

    public CorsoNonTrovatoException(String message, Throwable cause) {
        super(message, cause);
    }
}
