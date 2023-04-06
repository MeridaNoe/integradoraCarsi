package mx.edu.utez.centro_pokemon.service.consultorio;

import mx.edu.utez.centro_pokemon.models.consultorio.Consultorio;
import mx.edu.utez.centro_pokemon.models.consultorio.ConsultorioRepository;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ConsultorioService {
    @Autowired
   private ConsultorioRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Consultorio>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Consultorio> getOne(Integer id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Object> insert(Consultorio consultorio) {
        if (this.repository.existsById(consultorio.getIdConsultorio()))
            return new CustomResponse<>(
                    null, true, 400,
                    "Consultorio ya existe"
            );
        return new CustomResponse<>(
                this.repository.save(consultorio),
                false, 200,
                "Consultorio registrado correctamente"
        );
    }
}
