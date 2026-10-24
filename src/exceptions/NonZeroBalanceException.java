package exceptions;

public class NonZeroBalanceException extends RuntimeException{

    public NonZeroBalanceException(String message){
        super(message);
    }
}
