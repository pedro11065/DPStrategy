package br.padroes.strategy.strategy;

/**
 * Estratégia que calcula a média geométrica.
 */
public class Geometrica implements MediaStrategy {

    @Override
    public double calcularMedia(double p1, double p2) {
        return Math.sqrt(p1 * p2);
    }

    @Override
    public String verificarSituacao(double media) {
        return media >= 7.0 ? "Aprovado" : "Reprovado";
    }

    @Override
    public String getNome() {
        return "Média Geométrica";
    }
}
