package mx.edu.utez.centro_pokemon.models.tipopokemon;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TipoPokemonRepository extends MongoRepository<TipoPokemon, Integer> {
    List<TipoPokemon> findByTipoName(String tipoName);
}
