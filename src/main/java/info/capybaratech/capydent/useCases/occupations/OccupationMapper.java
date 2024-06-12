package info.capybaratech.capydent.useCases.occupations;

import info.capybaratech.capydent.entities.Occupation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OccupationMapper {
    OccupationMapper INSTANCE = Mappers.getMapper(OccupationMapper.class);
    OccupationResponseDto toOccupationResponseDto(Occupation occupation);
    Occupation toOccupation(CreateOccupationDto dto);

}
