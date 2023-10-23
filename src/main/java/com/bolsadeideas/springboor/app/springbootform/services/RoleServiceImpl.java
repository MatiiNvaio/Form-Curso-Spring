package com.bolsadeideas.springboor.app.springbootform.services;

import com.bolsadeideas.springboor.app.springbootform.models.domain.Role;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private List<Role> roles;

    public RoleServiceImpl(List<Role> lista) {
        this.roles = Arrays.asList(
                new Role(1, "Administrador", "ROLE_ADMIN"),
                new Role(2, "Usuario", "ROLE_USER"),
                new Role(3, "Moderador", "ROLE_MODERATOR"));
    }

    @Override
    public List<Role> listar() {
        return roles;
    }

    @Override
    public Role obtenerPorId(Integer id) {
        Role resultado = null;
        for(Role role:roles){
            if(id == role.getId()){
                resultado = role;
                break;
            }
        }
        return resultado;
    }
}
