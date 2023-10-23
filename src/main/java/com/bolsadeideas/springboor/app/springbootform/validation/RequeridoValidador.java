package com.bolsadeideas.springboor.app.springbootform.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        // esto valida si el apellido es vacio o tiene espacios en blanco
        if(value == null || value.isEmpty() || value.isBlank()){
            return false;
        }
        return true;
    }
}
