package mx.edu.utez.centro_pokemon.models.especie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EspecieRepository extends MongoRepository<Especie, Integer> {
List<Especie> findByEspecieName(String especieName);
}
