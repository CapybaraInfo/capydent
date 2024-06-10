package info.capybaratech.capydent.exceptions;

import info.capybaratech.capydent.messages.FieldValidationMessage;

import java.util.List;

public class FieldValidationException extends Exception {
    final List<FieldValidationMessage> exceptions;
   public FieldValidationException(String message, Throwable th, List<FieldValidationMessage> exceptions) {
        super(message, th);
        this.exceptions = exceptions;
    }
}
