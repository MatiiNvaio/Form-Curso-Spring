package com.bolsadeideas.springboor.app.springbootform.services;

import com.bolsadeideas.springboor.app.springbootform.models.domain.Pais;

import java.util.List;

public interface PaisService {

    public List<Pais> listar();
    public Pais obtenerPorId(Integer id);
}
