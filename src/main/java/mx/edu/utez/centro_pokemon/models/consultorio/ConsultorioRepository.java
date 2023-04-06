package mx.edu.utez.centro_pokemon.models.consultorio;

import mx.edu.utez.centro_pokemon.models.citamedica.CitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConsultorioRepository extends MongoRepository<Consultorio, Integer> {

    List<Consultorio> findByConsultorioName(String consultorioName);
}
