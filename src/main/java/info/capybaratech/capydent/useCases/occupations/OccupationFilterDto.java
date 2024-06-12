package info.capybaratech.capydent.useCases.occupations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OccupationFilterDto {
    String desciption;
    Boolean enabled;
}
