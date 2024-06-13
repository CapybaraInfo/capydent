package info.capybaratech.capydent.useCases.unit;

import com.github.f4b6a3.ulid.Ulid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UnitResponseDto {
    private Ulid id;
    private String description;
    private boolean enabled;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
