package com.bolsadeideas.springboor.app.springbootform.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RequeridoValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Requerido {

    String message() default "campo requerido - con anotaciones";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
