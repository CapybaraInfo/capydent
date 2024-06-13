package info.capybaratech.capydent.useCases.unit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UnitFilterDto {
    String description;
    Boolean enabled;
}
