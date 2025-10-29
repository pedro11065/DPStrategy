package br.padroes.strategy.strategy;

/**
 * Estratégia que calcula a média aritmética simples.
 */
public class Aritmetica implements MediaStrategy {

    @Override
    public double calcularMedia(double p1, double p2) {
        return (p1 + p2) / 2.0;
    }

    @Override
    public String verificarSituacao(double media) {
        return media >= 5.0 ? "Aprovado" : "Reprovado";
    }

    @Override
    public String getNome() {
        return "Média Aritmética";
    }
}
