/**
 * Título.
 * Insira aqui uma pequena descrição.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Jun 16, 2019 at 1:51:17 AM
 * @version 0.1
 */
package model;

public enum Pagamento {

    AVISTA("À vista"),
    DEBITO("Débito - Desconto de 3% pra operadora do cartão"),
    CREDITO("2x sem juros no cartão de crédito");

    private final String descricao;

    private Pagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
