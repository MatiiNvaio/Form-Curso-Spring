package com.bolsadeideas.springboor.app.springbootform.editors;

import com.bolsadeideas.springboor.app.springbootform.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private PaisService service;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {
        // verifica si el idString no es null,
        // si no lo es lo convierte en Integer
        try{
            Integer id = Integer.parseInt(idString);
            this.setValue(service.obtenerPorId(id));
        }catch (NumberFormatException e){
            setValue(null);
        }
    }
}
