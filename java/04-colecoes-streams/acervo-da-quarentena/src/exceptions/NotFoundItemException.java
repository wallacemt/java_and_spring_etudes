package exceptions;

public class NotFoundItemException extends RuntimeException {
    public NotFoundItemException(String code) {
        super("código " + code + " não existe");
    }
}
