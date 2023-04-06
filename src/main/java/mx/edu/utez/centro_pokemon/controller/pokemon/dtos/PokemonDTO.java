package mx.edu.utez.centro_pokemon.controller.pokemon.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.centro_pokemon.models.pokemon.Pokemon;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PokemonDTO {
    private int IdPokemon;
    private String Nombre;
    private String Edad;
    private String DescripcionFisica;

    public Pokemon getPokemon(){
        return new Pokemon(
                getIdPokemon(),
                getNombre(),
                getEdad(),
                getDescripcionFisica()
        );
    }
}
