package mx.edu.utez.centro_pokemon.models.tipopokemon;

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
@Document(collection = "TipoPokemon")
public class TipoPokemon {
    @Id
    private int idTipoPokemon;
    private String tipoName;
}
