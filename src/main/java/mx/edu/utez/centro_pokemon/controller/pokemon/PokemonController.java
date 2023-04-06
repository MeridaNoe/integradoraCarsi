package mx.edu.utez.centro_pokemon.controller.pokemon;

import jakarta.validation.Valid;
import mx.edu.utez.centro_pokemon.controller.person.dtos.PersonDTO;
import mx.edu.utez.centro_pokemon.controller.pokemon.dtos.PokemonDTO;
import mx.edu.utez.centro_pokemon.models.person.Person;
import mx.edu.utez.centro_pokemon.models.pokemon.Pokemon;
import mx.edu.utez.centro_pokemon.service.person.PersonService;
import mx.edu.utez.centro_pokemon.service.pokemon.PokemonService;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-centro/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {
    @Autowired
    private PokemonService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Pokemon>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Pokemon>> getOne(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Object>> insert(
            @Valid @RequestBody PokemonDTO pokemonDTO
    ) {
        return new ResponseEntity<>(
                this.service.insert(pokemonDTO.getPokemon()),
                HttpStatus.CREATED);
    }
}
