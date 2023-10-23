package com.bolsadeideas.springboor.app.springbootform.validation;

import com.bolsadeideas.springboor.app.springbootform.models.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component // para que se pueda inyectar y validar despues
public class UsuarioValidador implements Validator {

    // sirve para asignar qué objeto queremos validar, en este caso Usuario
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Usuario usuario = (Usuario)target;

        // verifica que campo tiene que validar y le asigna el mensaje de mensajes.properies
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.usuario.nombre");

//        if(!usuario.getIdentificador().matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")){
//            errors.rejectValue("identificador", "Pattern.usuario.identificador");
//        }
    }
}
