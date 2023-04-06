package mx.edu.utez.centro_pokemon.controller.region.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.centro_pokemon.models.region.Region;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegionDTO {
    private int IdRegion;
    private String NameRegion;

    public Region getRegion(){
        return new Region(
                getIdRegion(),
                getNameRegion()
        );
    }
}
