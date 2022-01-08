package br.com.java.javabeanvalidation.tipo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.java.javabeanvalidation.modelo.TipoVenda;
import br.com.java.javabeanvalidation.modelo.Venda;

public class TotalPorTipoValidator implements ConstraintValidator<TotalPorTipo, Venda>{

    @Override
    public void initialize(TotalPorTipo constraintAnnotation) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isValid(Venda venda, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub

        if (venda == null) {
            return false;
        }

        boolean valido = false;

        if (venda.getTipo() == TipoVenda.VendaPadrao && venda.getTotal() > 0) {
            valido = true;
        }

        if (venda.getTipo() == TipoVenda.VendaBrinde && venda.getTotal() == 0) {
            valido = true;
        }

        if (!valido) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            .addPropertyNode("Tipo").addConstraintViolation();
        }
        return valido;
    }
    
}
