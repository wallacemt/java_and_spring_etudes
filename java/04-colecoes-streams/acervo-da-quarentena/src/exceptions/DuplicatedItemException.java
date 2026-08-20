package exceptions;

public class DuplicatedItemException extends RuntimeException {
    public DuplicatedItemException(String code) {
        super("código " + code + " já está no acervo");
    }
}
