package br.padroes.facade.model;

import java.util.Objects;

/**
 * Agrega os três itens de um combo e calcula o preço total.
 */
public class Combo {
    private final ItemCombo burger;
    private final ItemCombo bebida;
    private final ItemCombo sobremesa;

    public Combo(ItemCombo burger, ItemCombo bebida, ItemCombo sobremesa) {
        this.burger = Objects.requireNonNull(burger, "burger não pode ser nulo");
        this.bebida = Objects.requireNonNull(bebida, "bebida não pode ser nulo");
        this.sobremesa = Objects.requireNonNull(sobremesa, "sobremesa não pode ser nulo");
    }

    public ItemCombo getBurger() {
        return burger;
    }

    public ItemCombo getBebida() {
        return bebida;
    }

    public ItemCombo getSobremesa() {
        return sobremesa;
    }

    public double getPrecoTotal() {
        return burger.getPreco() + bebida.getPreco() + sobremesa.getPreco();
    }
}
