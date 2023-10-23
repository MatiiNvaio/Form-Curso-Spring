package com.bolsadeideas.springboor.app.springbootform.services;

import com.bolsadeideas.springboor.app.springbootform.models.domain.Pais;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisServiceImpl implements PaisService{

    private List<Pais> lista;

    // construscor que inicializa la lista de paises
    public PaisServiceImpl() {
        this.lista = Arrays.asList(
                new Pais(1, "AR", "Argentina"),
                new Pais(2, "ES", "España"),
                new Pais(3, "CL", "Chile"),
                new Pais(4, "MX", "Mexico"),
                new Pais(5, "PE", "Peru"),
                new Pais(6, "CO", "Colombia"),
                new Pais(7, "VE", "Venezuela"));
    }

    @Override
    public List<Pais> listar() {
        return lista;
    }

    // compara el id pasado por argumento con el del pais y lo retorna
    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado = null;

        for(Pais pais:this.lista){
             if(id == pais.getId()){
                 resultado = pais;
                 break;
             }
        }
        return resultado;
    }
}
