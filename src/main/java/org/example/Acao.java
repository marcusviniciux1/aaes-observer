package org.example;

import java.util.Observable;

public class Acao extends Observable {

    private String nomeAcao;
    private double precoAtual;

    public Acao(String nomeAcao, Double precoAtual) {
        this.nomeAcao = nomeAcao;
        this.precoAtual = precoAtual;
    }

    public void atualizarPreco() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Acao{" +
                "nome='" + nomeAcao + '\'' +
                ", precoAtual=" + precoAtual +
                '}';
    }
}