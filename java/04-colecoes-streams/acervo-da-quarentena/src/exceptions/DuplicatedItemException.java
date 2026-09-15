package exceptions;

public class DuplicatedItemException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DuplicatedItemException(String code) {
        super("código " + code + " já está no acervo");
    }
}
