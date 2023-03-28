package mx.edu.utez.centro_pokemon.controller.especie.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.centro_pokemon.models.especie.Especie;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EspecieDTO {
    private int IdEspecie;
    private String EspecieName;

    public Especie getEspecie(){
        return new Especie(
                getIdEspecie(),
                getEspecieName()
        );
    }
}
