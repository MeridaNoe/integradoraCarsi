package mx.edu.utez.centro_pokemon.models.region;

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
@Document(collection = "Region")
public class Region {
    @Id
    private int IdRegion;
    private String NameRegion;
}
