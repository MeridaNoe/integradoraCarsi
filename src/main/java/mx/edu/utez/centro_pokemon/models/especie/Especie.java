package mx.edu.utez.centro_pokemon.models.especie;

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
@Document(collection = "Especie")
public class Especie {
    @Id
    private int IdEspecie;
    private String EspecieName;
}
