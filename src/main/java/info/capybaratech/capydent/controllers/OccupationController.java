package info.capybaratech.capydent.controllers;

import info.capybaratech.capydent.services.OccupationService;
import info.capybaratech.capydent.useCases.occupations.OccupationFilterDto;
import info.capybaratech.capydent.useCases.occupations.OccupationMapper;
import info.capybaratech.capydent.useCases.occupations.OccupationResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
