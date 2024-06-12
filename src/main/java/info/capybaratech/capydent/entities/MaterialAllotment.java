package info.capybaratech.capydent.entities;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialAllotment {
    private Ulid id = UlidCreator.getUlid();
    private Material material;
    private Double entryQuantity;
    private Double cost;
    private LocalDate expirationDate;
    private boolean enabled = true;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
