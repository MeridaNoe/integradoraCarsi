package mx.edu.utez.centro_pokemon.models.consultorio;

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
@Document(collection = "Consultorio")
public class Consultorio {
    @Id
    private int idConsultorio;
    private String ConsultorioName;
}
