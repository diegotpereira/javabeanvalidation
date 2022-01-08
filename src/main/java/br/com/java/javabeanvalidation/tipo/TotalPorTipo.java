package br.com.java.javabeanvalidation.tipo;

import java.lang.annotation.*;
import javax.validation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {TotalPorTipoValidator.class})
@Documented
public @interface TotalPorTipo {
    
    String message() default "Valor inválido para o tipo da venda.";

    Class<?>[]groups() default{};

    Class<? extends Payload>[] payload() default{};
}
