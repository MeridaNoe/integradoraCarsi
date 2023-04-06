package mx.edu.utez.centro_pokemon.controller.region;

import jakarta.validation.Valid;
import mx.edu.utez.centro_pokemon.controller.pokemon.dtos.PokemonDTO;
import mx.edu.utez.centro_pokemon.controller.region.dtos.RegionDTO;
import mx.edu.utez.centro_pokemon.models.pokemon.Pokemon;
import mx.edu.utez.centro_pokemon.models.region.Region;
import mx.edu.utez.centro_pokemon.service.pokemon.PokemonService;
import mx.edu.utez.centro_pokemon.service.region.RegionService;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-centro/region")
@CrossOrigin(origins = {"*"})
public class RegionController {
    @Autowired
    private RegionService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Region>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Region>> getOne(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Object>> insert(
            @Valid @RequestBody RegionDTO regionDTO
    ) {
        return new ResponseEntity<>(
                this.service.insert(regionDTO.getRegion()),
                HttpStatus.CREATED);
    }
}
