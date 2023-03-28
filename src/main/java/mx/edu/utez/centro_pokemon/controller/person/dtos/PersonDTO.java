package mx.edu.utez.centro_pokemon.controller.person.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.centro_pokemon.models.person.Person;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonDTO {
    private int idPerson;
    private String name;
    private String primerApellido;
    private String segundoApellido;
    private String Curp;

    public Person getPerson(){
        return new Person(
                getIdPerson(),
                getName(),
                getPrimerApellido(),
                getSegundoApellido(),
                getCurp()
        );
    }
}
