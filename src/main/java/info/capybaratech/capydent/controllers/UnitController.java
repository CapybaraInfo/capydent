package info.capybaratech.capydent.controllers;


import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.exceptions.NotFoundException;
import info.capybaratech.capydent.services.UnitService;
import info.capybaratech.capydent.useCases.unit.CreateUnitDto;
import info.capybaratech.capydent.useCases.unit.UnitMapper;
import info.capybaratech.capydent.useCases.unit.UnitResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@Tag(name = "Unit")
@RequestMapping(path = "/api/unit")
@AllArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class UnitController {
    private UnitService unitService;
    private UnitMapper unitMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Unit occupations")
    public Collection<UnitResponseDto> index(@RequestParam(value = "enabled", required = false) Boolean enabled) {
        var units = unitService.filter(enabled);
        return units.stream().map(u -> unitMapper.toUnitResponseDto(u)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UnitResponseDto show(@PathVariable Ulid id) throws NotFoundException {
        var response = unitService.getById(id);
        if (response.isPresent()) {
            return unitMapper.toUnitResponseDto(response.get());
        }
        throw new NotFoundException("unidade não encontrada");
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UnitResponseDto insert(@RequestBody @Valid CreateUnitDto unit) {
        var result = unitService.insert(unitMapper.toUnit(unit));
        return unitMapper.toUnitResponseDto(result);
    }

    @PutMapping(value = "/{id}")
    public UnitResponseDto update(@PathVariable Ulid id, @RequestBody @Valid CreateUnitDto unit) throws NotFoundException {
        var updatable = unitMapper.toUnit(unit);
        updatable.setId(id);
        var result = unitService.update(updatable);
        return unitMapper.toUnitResponseDto(result);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Ulid id) throws NotFoundException {
        this.unitService.delete(id);
    }
}
