package mx.edu.utez.centro_pokemon.service.pokemon;

import mx.edu.utez.centro_pokemon.models.person.Person;
import mx.edu.utez.centro_pokemon.models.person.PersonRepository;
import mx.edu.utez.centro_pokemon.models.pokemon.Pokemon;
import mx.edu.utez.centro_pokemon.models.pokemon.PokemonRepository;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class PokemonService {
    @Autowired
    private PokemonRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Pokemon>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Pokemon> getOne(Integer id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Object> insert(Pokemon person) {
        if (this.repository.existsById(person.getIdPokemon()))
            return new CustomResponse<>(
                    null, true, 400,
                    "Pokemon ya existe"
            );
        return new CustomResponse<>(
                this.repository.save(person),
                false, 200,
                "Pokemon registrado correctamente"
        );
    }
}
