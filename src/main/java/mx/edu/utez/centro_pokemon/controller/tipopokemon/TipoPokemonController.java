package mx.edu.utez.centro_pokemon.controller.tipopokemon;

import jakarta.validation.Valid;
import mx.edu.utez.centro_pokemon.controller.rol.dtos.RolDTO;
import mx.edu.utez.centro_pokemon.controller.tipopokemon.dtos.TipoPokemonDTO;
import mx.edu.utez.centro_pokemon.models.rol.Rol;
import mx.edu.utez.centro_pokemon.models.tipopokemon.TipoPokemon;
import mx.edu.utez.centro_pokemon.service.rol.RolService;
import mx.edu.utez.centro_pokemon.service.tipopokemon.TipoPokemonService;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-centro/tipo")
@CrossOrigin(origins = {"*"})
public class TipoPokemonController {
    @Autowired
    private TipoPokemonService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<TipoPokemon>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<TipoPokemon>> getOne(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Object>> insert(
            @Valid @RequestBody TipoPokemonDTO tipoPokemonDTO
    ) {
        return new ResponseEntity<>(
                this.service.insert(tipoPokemonDTO.getTipoPokemon()),
                HttpStatus.CREATED);
    }
}
