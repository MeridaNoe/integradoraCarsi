package mx.edu.utez.centro_pokemon.controller.consultorio.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.centro_pokemon.models.consultorio.Consultorio;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ConsultorioDTO {
    private int idConsultorio;
    private String ConsultorioName;

    public Consultorio getConsultorio(){
        return new Consultorio(
                getIdConsultorio(),
                getConsultorioName()
        );
    }
}
