package info.capybaratech.capydent.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FieldValidationMessage {
    String field;
    String message;
}
