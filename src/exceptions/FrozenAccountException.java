package exceptions;

public class FrozenAccountException extends RuntimeException{
    public FrozenAccountException(String message) {
        super(message);
    }
}
