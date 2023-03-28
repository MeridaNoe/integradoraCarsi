package mx.edu.utez.centro_pokemon.service.person;

import mx.edu.utez.centro_pokemon.models.person.Person;
import mx.edu.utez.centro_pokemon.models.person.PersonRepository;
import mx.edu.utez.centro_pokemon.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Person>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Person> getOne(Integer id) {
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Person> insert(Person person) {
        if (this.repository.existsById(person.getIdPerson()))
            return new CustomResponse<>(
                    null, true, 400,
                    "Persona ya existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(person),
                false, 200,
                "Persona registrada correctamente"
        );
    }
}
