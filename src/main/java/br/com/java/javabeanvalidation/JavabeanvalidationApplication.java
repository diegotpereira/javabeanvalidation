package br.com.java.javabeanvalidation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

import javax.validation.*;

import br.com.java.javabeanvalidation.modelo.ItemVenda;
import br.com.java.javabeanvalidation.modelo.TipoVenda;
import br.com.java.javabeanvalidation.modelo.Venda;

public class JavabeanvalidationApplication {

	public static void main(String[] args) {

		ValidatorFactory factory = 	Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		ItemVenda item = new ItemVenda();
		item.setDescricao("Camisa masculina M");
		item.setPreco(1F);
		item.setQuantidade(1);

		Venda venda = new Venda();
		venda.setData(Calendar.getInstance().getTime());
		venda.setTipo(TipoVenda.VendaPadrao);
		venda.setTotal(0);
		venda.setItens(new ArrayList<ItemVenda>() {{ add(item);}});

		Set<ConstraintViolation<Venda>> violation = validator.validate(venda);

		violation.stream().map(constraintViolation -> "Erro:"
		+ constraintViolation.getMessage()
		+ "["
		+ constraintViolation.getRootBeanClass().getSimpleName()
		+ ","
		+ constraintViolation.getPropertyPath()
		+"]").forEachOrdered(System.out::println);

	}

}
