package mx.edu.utez.centro_pokemon.models.pokemon;

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
@Document(collection = "Pokemon")
public class Pokemon {
    @Id
    private int IdPokemon;
    private String Nombre;
    private String Edad;
    private String DescripcionFisica;
}
