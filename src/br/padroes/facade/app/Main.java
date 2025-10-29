package br.padroes.facade.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.padroes.facade.facade.ComboFacade;

/**
 * Aplicação console que demonstra o uso do padrão Facade.
 */
public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        ComboFacade facade = new ComboFacade();
        exibirCabecalho();

        boolean continuar = true;
        while (continuar) {
            exibirMenu();
            int escolha = lerEscolhaUsuario();

            switch (escolha) {
                case 0 -> {
                    System.out.println("\n👋 Obrigado pela preferência! Volte sempre.");
                    continuar = false;
                }
                case 1, 2, 3 -> {
                    facade.criarCombo(escolha);
                    facade.exibirItens();
                    System.out.printf("\n💰 Total a pagar: R$ %.2f%n", facade.getPrecoTotal());
                }
                default -> System.out.println("❌ Opção inválida! Tente novamente.");
            }
        }

        SCANNER.close();
    }

    private static void exibirCabecalho() {
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║      LANCHONETE FAST-FOOD      ║");
        System.out.println("╚════════════════════════════════╝");
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU DE COMBOS ===");
        System.out.println("1 – Combo Master    (R$ 35,90)");
        System.out.println("2 – Super Combo     (R$ 32,50)");
        System.out.println("3 – Combo Kids      (R$ 22,90)");
        System.out.println("0 – Sair");
        System.out.print("\nSua escolha: ");
    }

    private static int lerEscolhaUsuario() {
        try {
            int escolha = SCANNER.nextInt();
            SCANNER.nextLine(); // consome quebra de linha
            return escolha;
        } catch (InputMismatchException ex) {
            SCANNER.nextLine(); // descarta entrada inválida
            return -1;
        }
    }
}
