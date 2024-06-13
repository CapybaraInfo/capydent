package info.capybaratech.capydent.repositories;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.Optional;

@Mapper
public interface UnitRepository {
    Collection<Unit> filter(@Param("enabled") Boolean enabled);

    void insert(@Param("unit") Unit unit);

    void update(@Param("unit") Unit unit);

    void delete(@Param("unit") Unit unit);

    Optional<Unit> getById(@Param("id") Ulid id);
}
