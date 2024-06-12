package info.capybaratech.capydent.useCases.materials.types;

import info.capybaratech.capydent.entities.MaterialType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MaterialTypeMapper {
    MaterialTypeMapper INSTANCE = Mappers.getMapper(MaterialTypeMapper.class);
    MaterialType toMaterialType(CreateMaterialTypeDto createMaterialTypeDto);
    MaterialType toMaterialType(UpdateMaterialTypeDto updateMaterialTypeDto);
    MaterialTypeResponseDto toMaterialTypeResponseDto(MaterialType materialType);
}
