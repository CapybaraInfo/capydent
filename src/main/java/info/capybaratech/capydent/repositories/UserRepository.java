package info.capybaratech.capydent.repositories;

import java.util.Collection;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.f4b6a3.ulid.Ulid;

import info.capybaratech.capydent.entities.User;

@Mapper
public interface UserRepository {
    Collection<User> filter(@Param("enabled") Boolean enabled);

    void insert(@Param("user") User user);

    void update(@Param("user") User user);
    
    void delete(@Param("user") User user);

    Optional<User> getById(@Param("id") Ulid id);
}
