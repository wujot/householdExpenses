package exceptions;

public class IncorrectMenuInputException extends Exception {
    public IncorrectMenuInputException() {
        super("Input can not be a word or character. You must type an integer.");
    }
}
