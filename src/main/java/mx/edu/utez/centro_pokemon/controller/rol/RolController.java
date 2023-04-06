package mx.edu.utez.centro_pokemon.controller.rol;

import jakarta.validation.Valid;
import mx.edu.utez.centro_pokemon.controller.region.dtos.RegionDTO;
import mx.edu.utez.centro_pokemon.controller.rol.dtos.RolDTO;
import mx.edu.utez.centro_pokemon.models.region.Region;
import mx.edu.utez.centro_pokemon.models.rol.Rol;
import mx.edu.utez.centro_pokemon.service.region.RegionService;
import mx.edu.utez.centro_pokemon.service.rol.RolService;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-centro/rol")
@CrossOrigin(origins = {"*"})
public class RolController {
    @Autowired
    private RolService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Rol>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Rol>> getOne(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Object>> insert(
            @Valid @RequestBody RolDTO rolDTO
    ) {
        return new ResponseEntity<>(
                this.service.insert(rolDTO.getRol()),
                HttpStatus.CREATED);
    }
}
