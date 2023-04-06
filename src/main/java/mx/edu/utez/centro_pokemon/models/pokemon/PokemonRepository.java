package mx.edu.utez.centro_pokemon.models.pokemon;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PokemonRepository extends MongoRepository<Pokemon, Integer> {
    List<Pokemon> findByNombre(String nombre);
}
