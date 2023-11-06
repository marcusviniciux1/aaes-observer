package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvestidorTest {

    @Test
    void deveNotificarUmInvestidor() {
        Acao acao = new Acao("PETR4", 35.69);
        Investidor investidor = new Investidor("Investidor 1");
        investidor.registrarInteresse(acao);
        acao.atualizarPreco();
        assertEquals("Investidor 1, o preço da ação foi atualizado para Acao{nome='PETR4', precoAtual=35.69}", investidor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarInvestidores() {
        Acao acao = new Acao("VALE3", 71.68);
        Investidor investidor1 = new Investidor("Investidor 1");
        Investidor investidor2 = new Investidor("Investidor 2");
        investidor1.registrarInteresse(acao);
        investidor2.registrarInteresse(acao);
        acao.atualizarPreco();
        assertEquals("Investidor 1, o preço da ação foi atualizado para Acao{nome='VALE3', precoAtual=71.68}", investidor1.getUltimaNotificacao());
        assertEquals("Investidor 2, o preço da ação foi atualizado para Acao{nome='VALE3', precoAtual=71.68}", investidor2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarInvestidor() {
        Acao acao = new Acao("ABEV3", 13.52);
        Investidor investidor1 = new Investidor("Investidor 1");
        acao.atualizarPreco();
        assertEquals(null, investidor1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarInvestidorAcaoPETR4() {
        Acao acao1 = new Acao("PETR4", 35.69);
        Acao acao2 = new Acao("ABEV3", 13.52);
        Investidor investidor1 = new Investidor("Investidor 1");
        Investidor investidor2 = new Investidor("Investidor 2");
        investidor1.registrarInteresse(acao1);
        investidor2.registrarInteresse(acao2);
        acao1.atualizarPreco();
        assertEquals("Investidor 1, o preço da ação foi atualizado para Acao{nome='PETR4', precoAtual=35.69}", investidor1.getUltimaNotificacao());
        assertEquals(null, investidor2.getUltimaNotificacao());
    }

}