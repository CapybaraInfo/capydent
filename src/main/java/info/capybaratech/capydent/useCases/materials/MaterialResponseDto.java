package info.capybaratech.capydent.useCases.materials;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import info.capybaratech.capydent.useCases.materials.types.MaterialTypeResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialResponseDto {
    private Ulid id = UlidCreator.getUlid();
    private String description;
    private MaterialTypeResponseDto materialType;
    private Double amount = 0d;
    private Double minimumQuantity = 0d;
    private Double cost = 0d;
    private boolean ignoreStock = false;
    private boolean enabled = true;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
