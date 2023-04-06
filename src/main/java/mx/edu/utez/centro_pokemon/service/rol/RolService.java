package mx.edu.utez.centro_pokemon.service.rol;

import mx.edu.utez.centro_pokemon.models.region.Region;
import mx.edu.utez.centro_pokemon.models.region.RegionRepository;
import mx.edu.utez.centro_pokemon.models.rol.Rol;
import mx.edu.utez.centro_pokemon.models.rol.RolRepository;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class RolService {
    @Autowired
    private RolRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Rol>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Rol> getOne(Integer id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Object> insert(Rol rol) {
        if (this.repository.existsById(rol.getIdRoles()))
            return new CustomResponse<>(
                    null, true, 400,
                    "Rol ya existe"
            );
        return new CustomResponse<>(
                this.repository.save(rol),
                false, 200,
                "Rol registrado correctamente"
        );
    }
}
