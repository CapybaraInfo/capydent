package info.capybaratech.capydent.repositories;

import com.github.f4b6a3.ulid.Ulid;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface Unit {
    void insert(Unit unit);
    void update(Unit unit);
    void delete(Unit unit);
    Optional<Unit> findById(@Param("id") Ulid id);
}
