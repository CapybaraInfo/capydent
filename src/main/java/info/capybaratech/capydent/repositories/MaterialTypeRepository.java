package info.capybaratech.capydent.repositories;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.MaterialType;
import org.apache.ibatis.annotations.Mapper;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Optional;

@Mapper
public interface MaterialTypeRepository {
    Collection<MaterialType> filter(Boolean enabled);

    void insert(MaterialType materialType);

    void update(MaterialType materialType);

    void delete(Ulid id, OffsetDateTime offsetDateTime);

    Optional<MaterialType> getById(Ulid id);
}
