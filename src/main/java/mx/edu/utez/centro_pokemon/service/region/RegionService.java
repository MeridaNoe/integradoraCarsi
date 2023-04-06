package mx.edu.utez.centro_pokemon.service.region;

import mx.edu.utez.centro_pokemon.models.region.Region;
import mx.edu.utez.centro_pokemon.models.region.RegionRepository;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class RegionService {
    @Autowired
    private RegionRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Region>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Region> getOne(Integer id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Object> insert(Region region) {
        if (this.repository.existsById(region.getIdRegion()))
            return new CustomResponse<>(
                    null, true, 400,
                    "Region ya existe"
            );
        return new CustomResponse<>(
                this.repository.save(region),
                false, 200,
                "Region registrada correctamente"
        );
    }
}
