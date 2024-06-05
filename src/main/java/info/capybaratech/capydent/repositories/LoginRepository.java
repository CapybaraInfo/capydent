package info.capybaratech.capydent.repositories;

import info.capybaratech.capydent.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.Optional;

@Mapper
public interface LoginRepository {
    Optional<User> loadUserByUsername(@Param("username") String username);
}
