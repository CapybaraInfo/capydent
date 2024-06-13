package info.capybaratech.capydent.repositories;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.Material;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.Optional;

@Mapper
public interface MaterialRepository {

    Collection<Material> filter(@Param("enabled") Boolean enabled, @Param("materialTypeId") Ulid materialTypeId, @Param("description") String description);
    void insert(@Param("material") Material material);
    void update(@Param("material") Material material);
    void delete(@Param("material") Material material);
    Optional<Material> getById(@Param("id") Ulid id);


}
