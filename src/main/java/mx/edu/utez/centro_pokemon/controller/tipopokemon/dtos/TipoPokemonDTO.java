package mx.edu.utez.centro_pokemon.controller.tipopokemon.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.centro_pokemon.models.tipopokemon.TipoPokemon;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TipoPokemonDTO {
    private int idTipoPokemon;
    private String tipoName;

    public TipoPokemon getTipoPokemon(){
        return new TipoPokemon(
                getIdTipoPokemon(),
                getTipoName()
        );
    }
}
