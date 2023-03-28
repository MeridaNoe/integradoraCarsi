package mx.edu.utez.centro_pokemon.service.citamedica;


import mx.edu.utez.centro_pokemon.models.citamedica.CitaMedica;
import mx.edu.utez.centro_pokemon.models.citamedica.CitaMedicaRepository;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class CitaMedicaService {
    @Autowired
    private CitaMedicaRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<CitaMedica>> getAll(){
        return new CustomResponse<>(
            this.repository.findAll(),
                false, 200, "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<CitaMedica> getOne(Integer id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<CitaMedica> insert(CitaMedica citaMedica) {
        if (this.repository.existsById( citaMedica.getIdCitaMedica()))
            return new CustomResponse<>(
                    null, true, 400,
                    "La cita medica ya existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(citaMedica),
                false, 200,
                "Cita medica registrada correctamente"
        );
    }
}
