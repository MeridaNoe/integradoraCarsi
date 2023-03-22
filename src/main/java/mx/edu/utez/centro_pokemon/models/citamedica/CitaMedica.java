package mx.edu.utez.centro_pokemon.models.citamedica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "CitaMedica")
public class CitaMedica {
    @Id
    private int idCitaMedica;
    private String Fecha;
    private String Padecimiento;
}
