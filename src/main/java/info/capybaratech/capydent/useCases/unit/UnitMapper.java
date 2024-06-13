package info.capybaratech.capydent.useCases.unit;

import info.capybaratech.capydent.entities.Occupation;
import info.capybaratech.capydent.entities.Unit;
import info.capybaratech.capydent.useCases.occupations.CreateOccupationDto;
import info.capybaratech.capydent.useCases.occupations.OccupationMapper;
import info.capybaratech.capydent.useCases.occupations.OccupationResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnitMapper {
    UnitMapper INSTANCE = Mappers.getMapper(UnitMapper.class);
    UnitResponseDto toUnitResponseDto(Unit unit);
    Unit toUnit(CreateUnitDto dto);
}
