package exceptions;

public class IncorrectPriceException extends Exception{
    public IncorrectPriceException() {
        super("Price can not be less or equal 0.");
    }
}
