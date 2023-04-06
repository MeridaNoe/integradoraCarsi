package mx.edu.utez.centro_pokemon.controller.rol.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.centro_pokemon.models.rol.Rol;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RolDTO {
    private int idRoles;
    private String RolesName;

    public Rol getRol(){
        return new Rol(
                getIdRoles(),
                getRolesName()
        );
    }
}
