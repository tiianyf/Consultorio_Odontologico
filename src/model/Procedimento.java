/**
 * Principais procedimentos odontológicos.
 * Foi criada uma classe enum para que demais alterações não possam ocorrer,
 * pois são valores fixos.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Jun 16, 2019 at 2:48:40 PM
 * @version 0.1
 */
package model;

public enum Procedimento {

    CLAREAMENTO("Clareamento dental", 400.00),
    TRATAMENTO("Tratamento ortodôntico", 500.00),
    IMPLANTE("Implante", 800.00),
    PROTESE("Próteses fixas", 631.00),
    ENXERTO("Enxerto gengival", 400.00),
    RASPAGEM("Periodontia", 250.00),
    ENDODONTIA("Endodontia", 432.00);

    private final String descricao;
    private final double valor;

    private Procedimento(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

}
