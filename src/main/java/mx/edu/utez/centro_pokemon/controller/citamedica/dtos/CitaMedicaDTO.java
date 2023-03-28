package mx.edu.utez.centro_pokemon.controller.citamedica.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.centro_pokemon.models.citamedica.CitaMedica;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CitaMedicaDTO {
    private int id;
    private String Fecha;
    private String Padecimiento;

    public CitaMedica getCitaMedica(){
        return new CitaMedica(
                getId(),
                getFecha(),
                getPadecimiento()
        );
    }
}
