package com.bolsadeideas.springboor.app.springbootform.editors;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.beans.PropertyEditorSupport;

public class NombreMayusEditor extends PropertyEditorSupport {

    // toma una cadena de texto y la convierte en mayúscuala
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toUpperCase().trim());
    }
}
