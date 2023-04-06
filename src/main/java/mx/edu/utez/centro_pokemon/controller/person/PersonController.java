package mx.edu.utez.centro_pokemon.controller.person;

import jakarta.validation.Valid;
import mx.edu.utez.centro_pokemon.controller.person.dtos.PersonDTO;
import mx.edu.utez.centro_pokemon.models.person.Person;
import mx.edu.utez.centro_pokemon.service.person.PersonService;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-centro/person")
@CrossOrigin(origins = {"*"})
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Person>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Person>> getOne(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Object>> insert(
            @Valid @RequestBody PersonDTO personDTO
    ) {
        return new ResponseEntity<>(
                this.service.insert(personDTO.getPerson()),
                HttpStatus.CREATED);
    }
}
