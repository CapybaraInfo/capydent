package info.capybaratech.capydent.useCases.occupations;

import com.github.f4b6a3.ulid.Ulid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OccupationResponseDto {
    private Ulid id;
    private String description;
    private boolean enabled;
}
