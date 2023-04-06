package mx.edu.utez.centro_pokemon.models.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, Integer> {
   List<Person> findByName(String name);
}
