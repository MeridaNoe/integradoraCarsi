package mx.edu.utez.centro_pokemon.controller.especie;

import jakarta.validation.Valid;
import mx.edu.utez.centro_pokemon.controller.especie.dtos.EspecieDTO;
import mx.edu.utez.centro_pokemon.models.especie.Especie;
import mx.edu.utez.centro_pokemon.service.especie.EspecieService;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-centro/especie")
@CrossOrigin(origins = {"*"})
public class EspecieController {
    @Autowired
    private EspecieService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Especie>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Especie>> getOne(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Object>> insert(
            @Valid @RequestBody EspecieDTO especieDTO
    ) {
        return new ResponseEntity<>(
                this.service.insert(especieDTO.getEspecie()),
                HttpStatus.CREATED);
    }
}
