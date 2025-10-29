package br.padroes.facade.model;

/**
 * Contrato comum para todos os itens que compõem um combo.
 */
public interface ItemCombo {
    /**
     * @return nome legível do item.
     */
    String getNome();

    /**
     * @return preço do item em reais.
     */
    double getPreco();
}
