package info.capybaratech.capydent.useCases.login;

import info.capybaratech.capydent.entities.LoginUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoginUserMapper {
    LoginUserMapper INSTANCE = Mappers.getMapper(LoginUserMapper.class);
    @Mapping(source = "role", target = "authority")
    LoginUserResponseDto toLoginUserResponseDto(LoginUser user);
}
