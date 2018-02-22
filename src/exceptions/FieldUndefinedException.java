package exceptions;

public class FieldUndefinedException extends Exception{
    public FieldUndefinedException() {
        super("Field of expense can not be null or less then two letters.");
    }
}
