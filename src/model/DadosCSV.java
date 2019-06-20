/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ch
 */
public interface DadosCSV {

    /**
     * Cabeçalho dos atributos da classe em maiúsculas separados por
     * ponto-e-vírgula.
     *
     * @return a linha contendo os atributos.
     */
    String getCabecalhoCSV();

    /**
     * Salvar (save) informação no arquivo CSV.
     *
     * @return uma string em linha única contendo as informações do objeto.
     */
    String getInfoCSV();

    /**
     * Carregar (load) informação do arquivo CSV para o objeto em questão.
     *
     * @param linhaCSV a linha contendo as informações que serão armazenadas no
     * objeto
     */
    void setInfoCSV(String linhaCSV);

    /**
     * Carrega o arquivo CSV.
     *
     * @param caminho o path do arquivo. Caso só o nome do arquivo for
     * especificado (e não o caminho completo com as pastas), presume-se que ele
     * esteja na pasta raiz do projeto, e não em subpastas.
     */
//    void carregarArquivo(String caminho);

    /**
     * Salva as informações em um arquivo CSV, com dados separados por
     * ponto-e-vírgula.
     *
     * @param caminho o path do arquivo. Caso só o nome do arquivo for
     * especificado (e não o caminho completo com as pastas), presume-se que ele
     * esteja na pasta raiz do projeto, e não em subpastas.
     */
//    void salvarArquivo(String caminho);
}
