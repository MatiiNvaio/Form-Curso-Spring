package com.bolsadeideas.springboor.app.springbootform.editors;

import com.bolsadeideas.springboor.app.springbootform.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class RolePropertyEditor extends PropertyEditorSupport {

    @Autowired
    private RoleService service;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {
        try{
            Integer id = Integer.parseInt(idString);
            this.setValue(service.obtenerPorId(id));
        }catch (NumberFormatException e){
            setValue(null);
        }
    }
}
