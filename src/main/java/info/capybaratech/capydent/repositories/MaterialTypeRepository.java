package info.capybaratech.capydent.repositories;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.MaterialType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Optional;

@Mapper
public interface MaterialTypeRepository {
    Collection<MaterialType> filter(@Param("enabled") Boolean enabled);

    void insert(@Param("materialType") MaterialType materialType);

    void update(@Param("materialType") MaterialType materialType);

    void delete(@Param("materialType") MaterialType materialType);

    Optional<MaterialType> getById(@Param("id") Ulid id);
}
