package info.capybaratech.capydent.entities;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import lombok.*;

import java.time.OffsetDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Occupation {
    private Ulid id = UlidCreator.getUlid();
    private String description;
    private boolean enabled = true;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt =  OffsetDateTime.now();
}
