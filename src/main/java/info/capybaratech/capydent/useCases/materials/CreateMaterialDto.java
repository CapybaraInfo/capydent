package info.capybaratech.capydent.useCases.materials;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMaterialDto {
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    private MaterialTypeAssoc materialType;
    private Double amount = 0d;
    private Double minimumQuantity = 0d;
    private Double cost = 0d;
    private boolean ignoreStock = false;
}
