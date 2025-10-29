package br.padroes.strategy.app;

import br.padroes.strategy.model.Disciplina;
import br.padroes.strategy.strategy.Aritmetica;
import br.padroes.strategy.strategy.Geometrica;
import br.padroes.strategy.strategy.MediaStrategy;

import java.util.Locale;

/**
 * Ponto de entrada da aplicação de demonstração do padrão Strategy.
 */
public final class Main {
    private static final Locale PT_BR = new Locale("pt", "BR");

    private Main() {
        // Impede instanciação
    }

    public static void main(String[] args) {
        testarEstrategia(new Aritmetica());
        System.out.println();
        testarEstrategia(new Geometrica());
    }

    private static void testarEstrategia(MediaStrategy estrategia) {
        Disciplina disciplina = new Disciplina(estrategia);
        disciplina.setNome("Padrões de Desenvolvimento");
        disciplina.setP1(10.0);
        disciplina.setP2(5.0);
        disciplina.calcularMedia();

        System.out.printf("=== %s ===%n", estrategia.getNome().toUpperCase(PT_BR));
        System.out.printf(PT_BR, "P1: %.2f  P2: %.2f  Média: %.2f  Situação: %s%n",
                disciplina.getP1(),
                disciplina.getP2(),
                disciplina.getMedia(),
                disciplina.getSituacao());
    }
}
