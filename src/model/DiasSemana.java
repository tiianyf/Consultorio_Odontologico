/*
 * Classe enum para classificar os dias da semana. Será utilizada para indicar
 * quais serão os dias de atendimento do Dentista.
 */
package model;

/**
 *
 * @author ch
 */
public enum DiasSemana {

    SEGUNDA("Segunda-feira"),
    TERCA("Terça-feira"),
    QUARTA("Quarta-feira"),
    QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira");

    private final String descricao;

    private DiasSemana(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
