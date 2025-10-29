package br.padroes.facade.model;

import java.util.Objects;

/**
 * Representa um sanduíche disponível para composição de combos.
 */
public class Burger implements ItemCombo {
    private final String nome;
    private final double preco;

    public Burger(String nome, double preco) {
        this.nome = Objects.requireNonNull(nome, "nome não pode ser nulo");
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("%s (R$ %.2f)", nome, preco);
    }
}
