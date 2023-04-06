package mx.edu.utez.centro_pokemon.service.especie;

import mx.edu.utez.centro_pokemon.models.especie.Especie;
import mx.edu.utez.centro_pokemon.models.especie.EspecieRepository;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class EspecieService {
    @Autowired
    private EspecieRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Especie>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Especie> getOne(Integer id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Object> insert(Especie especie) {
        if (this.repository.existsById(especie.getIdEspecie()))
            return new CustomResponse<>(
                    null, true, 400,
                    "Especie ya existe"
            );
        return new CustomResponse<>(
                this.repository.save(especie),
                false, 200,
                "Especie registrada correctamente"
        );
    }
}
