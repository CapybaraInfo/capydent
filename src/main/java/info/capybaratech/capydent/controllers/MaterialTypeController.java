package info.capybaratech.capydent.controllers;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.MaterialType;
import info.capybaratech.capydent.exceptions.NotFoundException;
import info.capybaratech.capydent.services.MaterialTypeService;
import info.capybaratech.capydent.useCases.materials.types.CreateMaterialTypeDto;
import info.capybaratech.capydent.useCases.materials.types.MaterialTypeMapper;
import info.capybaratech.capydent.useCases.materials.types.MaterialTypeResponseDto;
import info.capybaratech.capydent.useCases.materials.types.UpdateMaterialTypeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Tag(name = "Materials")
@RestController
@RequestMapping(path = "/api/material-types")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class MaterialTypeController {

    private MaterialTypeService materialTypeService;
    private MaterialTypeMapper materialTypeMapper;

    @Operation(summary = "List all material types")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MaterialTypeResponseDto> index(@RequestParam(value = "enabled", required = false) Boolean enabled) {
        return materialTypeService.filter(enabled).stream().map(i -> materialTypeMapper.toMaterialTypeResponseDto(i)).toList();
    }

    @Operation(summary = "Create a material type")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MaterialTypeResponseDto createMaterialType(@RequestBody @Valid CreateMaterialTypeDto dto) {
        MaterialType materialType = materialTypeMapper.toMaterialType(dto);
        var result = materialTypeService.insert(materialType);
        return materialTypeMapper.toMaterialTypeResponseDto(result);
    }

    @Operation(summary = "Update a material type")
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MaterialTypeResponseDto updateMaterialType(@PathVariable Ulid id, @RequestBody @Valid UpdateMaterialTypeDto dto) throws NotFoundException {
        MaterialType materialType = materialTypeMapper.toMaterialType(dto);
        materialType.setId(id);
        var result = materialTypeService.update(materialType);
        return materialTypeMapper.toMaterialTypeResponseDto(result);
    }

    @Operation(summary = "Delete a material type")
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteMaterialType(@PathVariable Ulid id) throws NotFoundException {
        materialTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get a material type")
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MaterialTypeResponseDto getMaterialTypeById(@PathVariable Ulid id) throws NotFoundException {
        var result = materialTypeService.getById(id);
        if (result.isPresent()) {
            return materialTypeMapper.toMaterialTypeResponseDto(result.get());
        }
        throw new NotFoundException("Recurso não existe");
    }
}
