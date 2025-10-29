package br.padroes.facade.facade;

import br.padroes.facade.model.Bebida;
import br.padroes.facade.model.Burger;
import br.padroes.facade.model.Combo;
import br.padroes.facade.model.ItemCombo;
import br.padroes.facade.model.Sobremesa;

/**
 * Fachada responsável por orquestrar a criação e exibição de combos.
 */
public class ComboFacade {
    private Combo combo;

    /**
     * Cria um combo baseado no código fornecido.
     *
     * @param codigo número do combo (1, 2 ou 3)
     */
    public void criarCombo(int codigo) {
        switch (codigo) {
            case 1 -> combo = criarComboMaster();
            case 2 -> combo = criarSuperCombo();
            case 3 -> combo = criarComboKids();
            default -> {
                System.out.println("❌ Código de combo inválido! Use 1, 2 ou 3.");
                combo = null;
            }
        }

        if (combo != null) {
            System.out.println("\n✅ Combo preparado com sucesso!");
        }
    }

    private Combo criarComboMaster() {
        return new Combo(
            new Burger("Big Cheddar", 18.00),
            new Bebida("Coca-Cola", 8.00),
            new Sobremesa("Sundae", 9.90)
        );
    }

    private Combo criarSuperCombo() {
        return new Combo(
            new Burger("Mega Bacon", 16.00),
            new Bebida("Guaraná", 7.50),
            new Sobremesa("Torta de Maçã", 9.00)
        );
    }

    private Combo criarComboKids() {
        return new Combo(
            new Burger("Mini Burger", 12.00),
            new Bebida("Suco Laranja", 6.00),
            new Sobremesa("Sorvete", 4.90)
        );
    }

    /**
     * Exibe todos os itens do combo atual.
     */
    public void exibirItens() {
        if (combo == null) {
            System.out.println("⚠️  Nenhum combo criado ainda!");
            return;
        }

        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║      DETALHES DO SEU COMBO     ║");
        System.out.println("╚════════════════════════════════╝");
        exibirItem("🍔 Burger", combo.getBurger());
        exibirItem("🥤 Bebida", combo.getBebida());
        exibirItem("🍰 Sobremesa", combo.getSobremesa());
    }

    private void exibirItem(String tipo, ItemCombo item) {
        System.out.printf("%-12s: %s - R$ %.2f%n", tipo, item.getNome(), item.getPreco());
    }

    /**
     * Retorna o preço total do combo atual.
     *
     * @return preço total ou 0 caso nenhum combo tenha sido criado.
     */
    public double getPrecoTotal() {
        if (combo == null) {
            return 0.0;
        }
        return combo.getPrecoTotal();
    }

    /**
     * Disponibiliza o combo atual para consultas adicionais.
     *
     * @return combo atual ou {@code null} caso nenhum tenha sido criado.
     */
    public Combo getCombo() {
        return combo;
    }
}
