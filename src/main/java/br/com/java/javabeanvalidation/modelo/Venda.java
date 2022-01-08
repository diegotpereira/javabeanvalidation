package br.com.java.javabeanvalidation.modelo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.*;

import br.com.java.javabeanvalidation.tipo.TotalPorTipo;

@TotalPorTipo(message = "O tipo não permite o valor informado")

public class Venda {

    @NotNull
    @Size(min = 1, message = "A lista de itens deve conter pelo menos um item")
    @Valid
    private List<ItemVenda> itens;

    @NotNull(message = "A data da venda não pode ser nula")
    private Date data;

    @DecimalMin(value = "0", message = "O valor da venda deve ser igual ou maior que zero")
    private float total;

    @NotNull(message = "O tipo da venda não pode ser nulo")
    private TipoVenda tipo;

    public Venda() {}

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public TipoVenda getTipo() {
        return tipo;
    }

    public void setTipo(TipoVenda tipo) {
        this.tipo = tipo;
    }

    
    
}
