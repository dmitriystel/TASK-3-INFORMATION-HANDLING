package by.epam.infohandling.exception;
// 5 ok
public class TextException extends Exception{
    public TextException() {
        super();
    }

    public TextException (String message) {
        super(message);
    }

    public TextException (Throwable cause) {
        super(cause);
    }

    public TextException(String message, Throwable cause) {
        super(message, cause);
    }

}
