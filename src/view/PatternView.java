/**
 * Interface contendo todos os métodos padrões para criação de interfaces
 * gráficas, como salvar no arquivo, ativar campos da interface etc.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Jun 17, 2019 at 1:55:10 AM
 * @version 0.1
 */
package view;

public interface PatternView {

    /**
     * Carrega lista(s) de objetos a partir de um arquivo (normalmente CSV).
     *
     * @param path o caminho do arquivo CSV.
     * @return true caso o arquivo tenha sido carregado com sucesso.
     */
    boolean loadFile(String path);

    /**
     * Salva a lista de objetos dentro de um arquivo (normalmente CSV).
     *
     * @param path o caminho do arquivo CSV.
     * @return true caso o arquivo tenha sido carregado com sucesso.
     */
    boolean saveOnFile(String path);

    /**
     * Altera a visibilidade dos campos da GUI, de acordo com o parâmetro.
     *
     * @param flag caso true, ativa, caso contrário, desativa.
     */
    void enableFields(boolean flag);

    /**
     * Limpa todos os campos de texto da GUI.
     */
    void clearAllFields();

    /**
     * Exibe a lista de objetos dentro de uma tabela (normalmente uma
     * AbstractTableModel).
     */
    void showTable();

    /**
     * Verifica se algum campo da GUI não foi preenchido pelo usuário.
     *
     * @return true caso haja algum campo vazio
     */
    boolean isAnyFieldMissing();

    /**
     * Verifica se determinado objeto existe dentro de uma estrutura
     * (normalmente uma lista). O critério para que o objeto exista normalmente
     * é caracterizado pelo seu ID (caso haja um, ou algo parecido). Caso já
     * tenha um mesmo ID dentro da estrutura, retorna true.
     *
     * @param o o objeto cuja existência está sendo verificada.
     * @return true caso o objeto já exista (ou caso o ID já esteja sendo
     * utilizado por outro objeto).
     */
    boolean isThere(Object o);

    /**
     * Busca por objeto dentro de uma estrutura (normalmente uma lista)
     * utilizando como referência um termo (normalmente ID, CPF etc).
     *
     * @param term o termo do objeto pesquisado.
     * @return o índice da estrutura (lista etc) cujo objeto está inserido.
     */
    int search(String term);

    /**
     * Copia o que está nos campos da GUI para o objeto.
     *
     * @param o o objeto que receberá os dados contidos nos campos da GUI.
     */
    void copyFromFieldsToObject(Object o);

    /**
     * Copia o que está no objeto para os campos da GUI.
     *
     * @param o o objeto cujos atributos serão copiados para os campos da GUI.
     */
    void copyFromObjectToFields(Object o);

}
