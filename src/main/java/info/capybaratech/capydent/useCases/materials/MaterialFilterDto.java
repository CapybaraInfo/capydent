package info.capybaratech.capydent.useCases.materials;

import com.github.f4b6a3.ulid.Ulid;
import org.springdoc.core.annotations.ParameterObject;

@ParameterObject
public record MaterialFilterDto(Boolean enable, Ulid materialTypeId, String description) {
}
