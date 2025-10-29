package br.padroes.strategy.model;

import br.padroes.strategy.strategy.MediaStrategy;

import java.util.Objects;

/**
 * Classe que utiliza o padrão Strategy para calcular a média de uma disciplina.
 */
public class Disciplina {
    private String nome;
    private double p1;
    private double p2;
    private double media;
    private String situacao;
    private MediaStrategy estrategia;

    public Disciplina(MediaStrategy estrategia) {
        setEstrategia(estrategia);
    }

    /**
     * Calcula a média e atualiza a situação delegando para a estratégia injetada.
     */
    public void calcularMedia() {
        MediaStrategy estrategiaAtual = Objects.requireNonNull(estrategia, "Estratégia não pode ser nula");
        this.media = estrategiaAtual.calcularMedia(this.p1, this.p2);
        this.situacao = estrategiaAtual.verificarSituacao(this.media);
    }

    public void setEstrategia(MediaStrategy estrategia) {
        this.estrategia = Objects.requireNonNull(estrategia, "Estratégia não pode ser nula");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
    }

    public double getP1() {
        return p1;
    }

    public void setP1(double p1) {
        this.p1 = validarNota(p1);
    }

    public double getP2() {
        return p2;
    }

    public void setP2(double p2) {
        this.p2 = validarNota(p2);
    }

    public double getMedia() {
        return media;
    }

    public String getSituacao() {
        return situacao;
    }

    public MediaStrategy getEstrategia() {
        return estrategia;
    }

    private double validarNota(double nota) {
        if (nota < 0.0 || nota > 10.0) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10");
        }
        return nota;
    }
}
