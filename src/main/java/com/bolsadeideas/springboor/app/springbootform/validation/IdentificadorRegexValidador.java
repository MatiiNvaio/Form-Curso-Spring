package com.bolsadeideas.springboor.app.springbootform.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if(value.matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")){
            return true;
        }
        return false;
    }
}
