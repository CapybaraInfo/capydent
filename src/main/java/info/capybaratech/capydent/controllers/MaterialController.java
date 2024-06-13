package info.capybaratech.capydent.controllers;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.exceptions.NotFoundException;
import info.capybaratech.capydent.services.MaterialService;
import info.capybaratech.capydent.useCases.materials.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Tag(name = "Materials")
@RestController
@RequestMapping(path = "/api/materials")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class MaterialController {

    private MaterialService materialService;
    private MaterialMapper materialMapper;

    @Operation(summary = "List all materials by filter")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Parameter(name = "materialTypeId", schema = @Schema(type = "string"))
    public Collection<MaterialResponseDto> index(MaterialFilterDto filters) {
        var materials = materialService.filter(filters.enable(),filters.materialTypeId(), filters.description());
        return materials.stream().map(m -> materialMapper.toMaterialResponse(m)).toList();
    }

    @Operation(summary = "Get materials by id")
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public MaterialResponseDto getById(@PathVariable("id") Ulid id) throws NotFoundException {
        var material = materialService.getById(id);
        if(material.isPresent()) {
            return materialMapper.toMaterialResponse(material.get());
        }
        throw new NotFoundException("Recurso não existe");
    }

    @Operation(summary = "Create a new material")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MaterialResponseDto createMaterial(@RequestBody @Valid CreateMaterialDto createMaterialDto) {
        var material = materialMapper.toMaterial(createMaterialDto);
        var dbMaterial = materialService.insert(material);
        return materialMapper.toMaterialResponse(dbMaterial);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "update material by id")
    public MaterialResponseDto updateMaterial(@RequestBody @Valid UpdateMaterialDto updateMaterialDto, @PathVariable("id") Ulid id) throws NotFoundException {
        var material = materialMapper.toMaterial(updateMaterialDto);
        material.setId(id);
        var dbMaterial = materialService.update(material);
        return materialMapper.toMaterialResponse(dbMaterial);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "delete material by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMaterial(@PathVariable("id") Ulid id) throws NotFoundException {
        materialService.delete(id);
    }

}
