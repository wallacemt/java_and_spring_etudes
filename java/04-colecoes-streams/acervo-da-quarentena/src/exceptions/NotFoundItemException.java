package exceptions;

public class NotFoundItemException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFoundItemException(String code) {
        super("código " + code + " não existe");
    }
}
