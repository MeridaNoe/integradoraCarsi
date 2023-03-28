package mx.edu.utez.centro_pokemon.controller.consultorio;

import jakarta.validation.Valid;
import mx.edu.utez.centro_pokemon.controller.consultorio.dtos.ConsultorioDTO;
import mx.edu.utez.centro_pokemon.models.consultorio.Consultorio;
import mx.edu.utez.centro_pokemon.service.consultorio.ConsultorioService;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-centro/consultorio")
@CrossOrigin(origins = {"*"})
public class ConsultorioController {
    @Autowired
    private ConsultorioService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Consultorio>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Consultorio>> getOne(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Consultorio>> insert(
            @Valid @RequestBody ConsultorioDTO consultorioDTO
    ) {
        return new ResponseEntity<>(
                this.service.insert(consultorioDTO.getConsultorio()),
                HttpStatus.CREATED);
    }
}
