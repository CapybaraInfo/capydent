package info.capybaratech.capydent.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorMessage {
    Integer status;
    String type;
    String title;
    String details;
    OffsetDateTime issueAt;
    List<FieldValidationMessage> validationMessages;
}
