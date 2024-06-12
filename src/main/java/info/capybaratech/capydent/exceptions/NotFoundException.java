package info.capybaratech.capydent.exceptions;

public class NotFoundException extends  Exception{
    public NotFoundException(String message) {
        super(message);
    }
    public NotFoundException(String message, Throwable th) {
        super(message, th);
    }
}
