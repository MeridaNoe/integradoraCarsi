package mx.edu.utez.centro_pokemon.models.region;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RegionRepository extends MongoRepository<Region, Integer> {
    List<Region> findByNameRegion(String nameRegion);
}
