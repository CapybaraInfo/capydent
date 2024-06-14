package info.capybaratech.capydent.controllers;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.exceptions.NotFoundException;
import info.capybaratech.capydent.services.OccupationService;
import info.capybaratech.capydent.useCases.occupations.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@Tag(name = "Occupations")
@RequestMapping(path = "/api/occupations")
@AllArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class OccupationController {

    private OccupationService occupationService;
    private OccupationMapper occupationMapper;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Filter occupations")
    public Collection<OccupationResponseDto> index(@ParameterObject OccupationFilterDto filterDto) {
       var occupations = occupationService.filter(filterDto.getDesciption(), filterDto.getEnabled());
       return occupations.stream().map(o -> occupationMapper.toOccupationResponseDto(o)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OccupationResponseDto show(@PathVariable Ulid id) throws NotFoundException {
        var response = occupationService.getById(id);
        if (response.isPresent()) {
            return occupationMapper.toOccupationResponseDto(response.get());
        }
        throw new NotFoundException("Occupation with id = " + id + " not found");
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public OccupationResponseDto insert(@RequestBody CreateOccupationDto occupation) {
        var result = occupationService.insert(occupationMapper.toOccupation(occupation));
        return occupationMapper.toOccupationResponseDto(result);
    }

    @PutMapping(value = "/update/{id}")
    public OccupationResponseDto update(@PathVariable Ulid id, @RequestBody UpdateOccupationDto occupation) throws NotFoundException {
        var updatable = occupationMapper.toOccupation(occupation);
        updatable.setId(id);
        var result = occupationService.update(updatable);
        return occupationMapper.toOccupationResponseDto(result);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Ulid id) throws NotFoundException {
        this.occupationService.delete(id);
    }

}
