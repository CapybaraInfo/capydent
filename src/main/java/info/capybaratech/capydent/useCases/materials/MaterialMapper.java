package info.capybaratech.capydent.useCases.materials;

import info.capybaratech.capydent.entities.Material;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MaterialMapper {
    MaterialMapper INSTANCE = Mappers.getMapper(MaterialMapper.class);

    Material toMaterial(CreateMaterialDto createMaterialDto);

    Material toMaterial(UpdateMaterialDto updateMaterialDto);

    MaterialResponseDto toMaterialResponse(Material material);
}
