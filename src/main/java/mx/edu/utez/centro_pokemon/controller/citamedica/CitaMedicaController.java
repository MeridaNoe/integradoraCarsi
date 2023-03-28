package mx.edu.utez.centro_pokemon.controller.citamedica;


import jakarta.validation.Valid;
import mx.edu.utez.centro_pokemon.controller.citamedica.dtos.CitaMedicaDTO;
import mx.edu.utez.centro_pokemon.models.citamedica.CitaMedica;
import mx.edu.utez.centro_pokemon.service.citamedica.CitaMedicaService;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-centro/cita")
@CrossOrigin(origins = {"*"})
public class CitaMedicaController {
    @Autowired
    private CitaMedicaService service;


    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<CitaMedica>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<CitaMedica>> getOne(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<CitaMedica>> insert(
            @Valid @RequestBody CitaMedicaDTO citaMedicaDTO
    ) {
        return new ResponseEntity<>(
                this.service.insert(citaMedicaDTO.getCitaMedica()),
                HttpStatus.CREATED);
    }
}
