package info.capybaratech.capydent.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping(path = "/api/home")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class HomeController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(Collections.singletonMap("message","Hello i am working with security"));
    }

}
