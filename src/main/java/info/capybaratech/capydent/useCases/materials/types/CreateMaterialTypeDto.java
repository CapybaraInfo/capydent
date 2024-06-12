package info.capybaratech.capydent.useCases.materials.types;

import com.github.f4b6a3.ulid.Ulid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMaterialTypeDto {
    @NotEmpty
    private String description;
}
