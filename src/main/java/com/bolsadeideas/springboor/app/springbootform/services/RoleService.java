package com.bolsadeideas.springboor.app.springbootform.services;


import com.bolsadeideas.springboor.app.springbootform.models.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> listar();
    public Role obtenerPorId(Integer id);
}
