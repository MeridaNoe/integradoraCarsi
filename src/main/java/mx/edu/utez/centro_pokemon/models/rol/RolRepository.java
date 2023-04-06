package mx.edu.utez.centro_pokemon.models.rol;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RolRepository extends MongoRepository<Rol, Integer> {
    List<Rol> findByRolesName(String rolesName);
}
