package mx.edu.utez.centro_pokemon.models.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Person")
public class Person {
    @Id
    private int idPerson;
    private String name;
    private String primerApellido;
    private String segundoApellido;
    private String Curp;
}
