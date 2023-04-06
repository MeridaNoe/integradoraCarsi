package mx.edu.utez.centro_pokemon.models.citamedica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CitaMedicaRepository extends MongoRepository<CitaMedica, String> {
  List<CitaMedica>  findByPadecimiento(String padecimiento);
}
