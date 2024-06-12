package info.capybaratech.capydent.entities;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialType {
    private Ulid id = UlidCreator.getUlid();
    private String description;
    private boolean enabled = true;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt =  OffsetDateTime.now();
}
