package mx.edu.utez.centro_pokemon.service.tipopokemon;

import mx.edu.utez.centro_pokemon.models.tipopokemon.TipoPokemon;
import mx.edu.utez.centro_pokemon.models.tipopokemon.TipoPokemonRepository;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class TipoPokemonService {
    @Autowired
    private TipoPokemonRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<TipoPokemon>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<TipoPokemon> getOne(Integer id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Object> insert(TipoPokemon tipoPokemon) {
        if (this.repository.existsById(tipoPokemon.getIdTipoPokemon()))
            return new CustomResponse<>(
                    null, true, 400,
                    "Tipo de pokemon ya existe"
            );
        return new CustomResponse<>(
                this.repository.save(tipoPokemon),
                false, 200,
                "Tipo de pokemon registrado correctamente"
        );
    }
}
